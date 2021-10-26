# 零成本BFF解决方案

## Capa Bff

`capa-bff`仅提供一个接口，并接收一个大`json`格式的请求体数据。内部会对请求体数据进行解析，并根据解析结果决定接口调用顺序，再根据需要对接口返回值进行裁剪。
接口请求体数据格式整体示例如下：
```
{
  "10011111": [
    "getUserInfo":(
      request: {
          "id": 1
       },
      requestHeader: {
          "timeout": "5000"
      },
      response: {
          "result.userInfo.id": "user.id",
          "result.userInfo.name": "user.name",
          "result.userInfo.age" : "user.age"
      }
    ),
    "getDepartmentInfoByUserId": (
      request: {
        "userId": "${user.id}"
      },
      response: {
        "result.departmentInfo.name" : "user.departmentName"
      }
    )
  ]
}
```
接口最终返回响应体示例如下：
```json5
{
  "user": {
    "id": 1,
    "name": "zhangsan",
    "age" : 1,
    "departmentName": "后勤保障部"
  }
}
```

### DSL支持的数据类型
- 字符串
- 数字
- 对象
- 数组

# 相关概念定义
## 1、大`json`格式的请求体
该请求体有一个或多个**服务调用对象**组合而成。如：
```
{
  "appId":服务调用对象,
  "appId":服务调用对象
}
```

## 2、服务调用对象
每个服务调用对象由一个或多个**方法调用对象**。如：
```
{
   "方法名称": 方法调用对象,
   "方法名称": 方法调用对象
}
```

## 3、方法调用对象
方法调用对象由单个的`request`、`response`组成
```
{
   "request": 通用request对象,
   "response": 通用response对象
}
```

## 4、通用`request`对象
通过`request`对象由一个或多个`key`、`value`对组合而成；其内部数据仅代表要调用方法的请求体，暂不考虑请求头数据。如：
```
{
  "key1": "normalValue",
  "key2": "${result.name}"
}
```
其中`value`可以用`${}`来表示其他接口返回数据的裁剪结果。暂不考虑对返回数据进行二次计算

## 5、通用`response`对象
通用`response`对象由一个或多个`key`、`value`对组合而成。其中`key`表示接口返回数据，其中`.`表示其层级关系；`value`表示该数据裁剪后的结果，其中`.`表示其层级关系。如：
```
{
  "a.b.name": "result.name"
}
```

# 如何实现
`capa-bff`接收到大`json`数据后，将其解析成多个**方法调用对象**；根据方法调用对象的`request`是否包含`${}`，将其分为前置请求、后置请求。前置请求类型的方法调用对象立马执行方法调用对象，并根据`reponse`对返回结果进行裁剪，并将裁剪结果方法一个上下文对象；并通知后置请求检查自己`request`是否满足要求，如果满足就将其变为后置请求，执行后置请求流程。在所有请求数据都获取之后，将返回数据整合一下，并返回给调用者。


## 服务循环依赖/无依赖判断

### 无环图的请求示例

```
{
    "20725.gscontentcenterservice": [
        "getkoldetail":(
            request: {
                "kolNo" : "1"
            },
            response: {
                "kolOrderDetail.id" : "kol.id",
                "kolOrderDetail.applyId" : "kol.applyId",
            }
        )
    ],
    "20725.gscontentcenterservice":[
        "getkolapplydetail":(
            request: {
                "kolApplyNo" : "${kol.applyId}"
            },
            response: {
                "user.userId" : "user.id",
            }
        )      
    ],
     "20725.gscontentcenterservice":[
        "getUserInfo":(
            request: {
                "userId" : "${user.id}"
            },
            response: {
                "livingLiveInfo.liveId" : "live.id"
                "livingLiveInfo.liveUserId" : "live.user.id"
                "firstArticleInfo.articleId" : "article.id"
            }
        )      
    ],
    "24901.livebackendservice":[
        "getLiveInfo":(
            request: {
                "liveId" : "${live.id}",
                "userId" : "${live.user.id}"
            },
            response: {
                "article.info.id" : "article.id"
            }
        )      
    ],
    "11933.contentdeliveryservice":[
        "getarticleinfo":(
            request: {
                "artilceid" : "${artilce.id}"
            },
            response: {
                "*"
            }
        )      
    ]
}
```
此时依赖关系如下：对应的图如下
1. ${kol.applyId} 
   - 依赖服务 20725.gscontentcenterservice#getkoldetail；
   - request服务:20725.gscontentcenterservice#getkolapplydetail
2. ${user.id} 
   - 依赖服务 20725.gscontentcenterservice#getkolapplydetail 
   - request服务:20725.gscontentcenterservice#getUserInfo
3. ${live.id} 
   - 依赖服务 20725.gscontentcenterservice#getkolapplydetail；
   - request服务:24901.livebackendservice#getLiveInf
4. ${live.user.id} 
   - 依赖服务 20725.gscontentcenterservice#getkolapplydetail；
   - request服务:24901.livebackendservice#getLiveInfo
5. ${article.id} 
   - 依赖服务 24901.livebackendservice#getLiveInfo；
   - request服务:11933.contentdeliveryservice#getarticleinfo

![](./images/无环有向图.png)

所以，我们可以将一个字段依赖的上游服务和所使用的服务，构造成如下对象

```java
class DependOnFieldInfo {
   /**
    * 需要依赖上下文的字段
    */
   private String field;
   /**
    * 依赖的服务请求
    */
   private InvocationRequest<T> dependOnServiceMethod;
   /**
    * 字段使用的服务请求
    */
   private InvocationRequest<T> requestServiceMethod;
}
```

有了以上的信息后（有了${}对应的请求和上游请求，理论上就可以构造一个有向图了。<br/>
所以可以通过serviceMethod构造图，即一个节点是一个serviceMethod，【appid#method】。e.g.：20725.gscontentcenterservice#getkoldetail

再构造如下有向图的相关类
端点信息：即一个serviceMethod的string
```
private InvocationRequest serviceMethod;
```

边信息
```java
class InvocationEdge<T> {
   /**
    * 边的起点（请求的来源）
    */
   private InvocationRequest<T> src;
   /**
    * 边的终点（请求的去向）
    */
   private InvocationRequest<T> dest;
}

```

定义方法，来实现对图的构造
```java
class GraphUtil {
   public void queryHasIllegalInvocation(List<DependOnFieldInfo<T>> fieldInfoList) throws IllegalInvocationRequestException {

   }
}
```

最后将图转换为邻接矩阵，进行是否有环的判断

![](https://img-blog.csdnimg.cn/20200702221607224.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poaWxhbW91NzU0OQ==,size_16,color_FFFFFF,t_70)
> 遵循深度优先搜索到思路，我们这里默认按行进行遍历，对于第一行，起始节点就是第一行对应到那个元素0，遍历到第二个元素时发现不为0，则节点0可以到达节点1；接着以节点1作为中转点，遍历节点1对应的那一行，也就是矩阵中的第二行，发现节点1可以到达节点2；同理，继续遍历节点2所在的行，发现节点2可以到达节点0，而节点0正是起始节点，也就是发现了有向图中存在着环路。
