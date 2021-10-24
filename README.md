# 零成本BFF解决方案

## Capa Bff

`capa-bff`仅提供一个接口，并接收一个大`json`格式的请求体数据。内部会对请求体数据进行解析，并根据解析结果决定接口调用顺序，再根据需要对接口返回值进行裁剪。
接口请求体数据格式整体示例如下：
```
{
  "10011111": [
    "getUserInfo":(
      "request": {
          "id": 1
       },
      "response": {
          "result.userInfo.id": "user.id",
          "result.userInfo.name": "user.name",
          "result.userInfo.age" : "user.age"
      }
    ),
    "getDepartmentInfoByUserId": (
      "request": {
        "userId": "${user.id}"
      },
      "response": {
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


