package group.rxcloud.capa.bff.controller;

import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import group.rxcloud.capa.bff.domain.BffApiDomain;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;
import spec.proto.bff.v1.BffApiProto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BFFController {

    @Autowired
    private CapaRpcClient capaRpcClient;

    /**
     * <pre>
     *     select user.name from 12345.hello.user
     *
     *
     *     {
     *         "12345.hello": {
     *             "user": {
     *                 "request": {
     *                     id: 1
     *                     info : {
     *
     *                     }
     *                 },
     *                 "response": {
     *                     name: user.name,
     *                     extra.address.id: user.address.id
     *                 },
     *             },
     *             "address": {
     *                 "request": {
     *                     id: ${user.address.id}
     *                 },
     *                 "response":{
     *                     name: user.address.name
     *                     global.latitude: user.address.latitude
     *                 }
     *             }
     *         },
     *         "12345.hello": {
     *              ....
     *         }
     *     }
     *
     *
     *     {
     *         "user": {
     *             name: hahaha,
     *             address: {
     *                 id: 2,
     *                 name: shanghai,
     *                 latitude: 1.0
     *             }
     *         }
     *     }
     *
     *
     *
     *
     *
     *
     * </pre>
     */

    /**
     * <pre>
     *     body =
     *     {
     *         "12345.hello": {
     *             "checkhealth": {
//     *                 "request": {
     *                 "pid": "1234"
//     *                 },
//     *                 "response": {
//     *                     a.d.id: projcet.name,
//     *                     name
//     *                 },
                        "metadata": {
                        "invokemode: asnyc
                      }
     *             },
     *             "sayhello": {
     *                 "request": {
     *                     "cid": "${project.name}"
     *                 },
//     *                 "response": {
//     *                     project
//     *                     group
//     *                 }
     *             }
     *         },
     *         "12314.hhhhh": {
     *             "checkhealth": {
     *                 "request": {
     *                     "pid": "1234"
     *                 },
//     *                 "response": {
//     *                     id,
//     *                     name
//     *                 }
     *             },
     *             "sayhello": {
     *                 "request": {
     *                     "cid": "1234"
     *                 },
//     *                 "response": {
//     *                     project,
//     *                     group
//     *                 }
     *             }
     *         }
     *     }
     * </pre>
     */
    @RequestMapping(value = "/capabff", method = RequestMethod.POST, produces = "application/x-protobuf")
    public @ResponseBody
    Mono<BffApiProto.BffApiResponse> bff(@RequestBody BffApiProto.BffApiRequest request) throws Exception {
        final BffApiProto.RequestBody body = request.getBody();
        final List<FieldMask> fieldMaskList = request.getFieldMaskList();

        /*
         body ->
         <12345.hello#check, json>
         <12345.hello#say, json>
         <21414.hhhh#check, json>
        */
        // TODO: 2021/10/19 反序列化body为查询API对象，并且分割不同的方法调用
        Map<String, BffApiDomain> bffApiDomainMap = new HashMap<>();

        List<Mono<JSON>> invokeList = new ArrayList<>();
        // TODO: 2021/10/19 遍历调用每个API方法对象
        for (FieldMask fieldMask : fieldMaskList) {
            // TODO: 2021/10/19 通过fieldMask获取要调用的目标服务
            String target = "12345.hello#checkHealth";

            BffApiDomain bffApiDomain = bffApiDomainMap.get(target);

            Mono<JSON> responseMono = capaRpcClient.invokeMethod(
                    bffApiDomain.getAppId(),
                    bffApiDomain.getMethod(),
                    bffApiDomain.getData(),
                    HttpExtension.POST,
                    TypeRef.get(JSON.class));

            // TODO: 2021/10/19 获取目标服务的调用模式
            // TODO IMPORT FieldMask拓展，支持一些自定义参数
            // TODO IMPORT
            // TODO IMPORT
            String mode = "async/sync";
            switch (mode) {
                case "async": {
                    Mono<JSON> map = responseMono.map(json -> {
                        // TODO: 2021/10/19 字段裁剪
                        // TODO IMPORT
                        // TODO IMPORT
                        // TODO IMPORT
                        // FieldMaskUtil.merge(fieldMask, json, jsonBuilder);
                    });
                    // 把裁剪完的对象放入list
                    invokeList.add(map);
                    break;
                }
                case "sync": {
                    // TODO: 2021/10/19 同步获取响应
                    JSON response = responseMono.block();
                    // TODO: 2021/10/19 字段裁剪
                    // FieldMaskUtil.merge(fieldMask, json, jsonBuilder);
                    Mono<Object> mono = Mono.just(response);
                    invokeList.add(map);
                    break;
                }
            }
        }

        Mono.zip(invokeList, objects -> {
            // TODO 聚合异步/同步的结果
            // TODO 序列化
            byte[] data = serialize;
            /*
                        // TODO IMPORT
                        // TODO IMPORT
                        // TODO IMPORT
                        如何整合起来
            * {
            *   "12345.hello": {
            *       "check": {
            *           id,
                        name
            *       }
            *   },
            *   "12345.hello": {
            *       "check": {
            *           cid,
                        model
            *       }
            *   }
            * }
            */
        });

        BffApiProto.BffApiResponse bffApiResponse = BffApiProto.BffApiResponse.newBuilder()
                .setData(ByteString.copyFrom(data))
                .build();
        return Mono.just(bffApiResponse);
    }

    /**
     * id: 1234.hello.method
     *
     * value:
     *
     * a.b.c.name: project.name
     *
     *
     * id: 1234.hello.say
     *
     * value:
     *
     * b.d.c.desc: project.desc
     * \
     *
     * {
     *     project :{
     *         name:
     *         desc
     *     }
     * }
     */
}
