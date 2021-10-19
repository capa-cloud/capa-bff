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

    @RequestMapping(value = "/capabff", method = RequestMethod.POST, produces = "application/x-protobuf")
    public @ResponseBody
    Mono<BffApiProto.BffApiResponse> bff(@RequestBody BffApiProto.BffApiRequest request) throws Exception {
        final BffApiProto.RequestBody body = request.getBody();
        final List<FieldMask> fieldMaskList = request.getFieldMaskList();

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
            String mode = "async/sync";
            switch (mode) {
                case "async": {
                    Mono<JSON> map = responseMono.map(json -> {
                        // TODO: 2021/10/19 字段裁剪
                        // FieldMaskUtil.merge(fieldMask, json, jsonBuilder);
                    });
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
        });

        // TODO 序列化
        byte[] data = serialize;

        BffApiProto.BffApiResponse bffApiResponse = BffApiProto.BffApiResponse.newBuilder()
                .setData(ByteString.copyFrom(data))
                .build();
        return Mono.just(bffApiResponse);
    }
}
