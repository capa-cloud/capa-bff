package group.rxcloud.capa.bff.controller;

import com.google.protobuf.FieldMask;
import group.rxcloud.capa.bff.domain.BffApiDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spec.proto.bff.v1.BffApiProto;

import java.util.List;

@Controller
public class BFFController {

    @RequestMapping(value = "/capabff", method = RequestMethod.POST, produces = "application/x-protobuf")
    public @ResponseBody
    BffApiProto.BffApiResponse bff(@RequestBody BffApiProto.BffApiRequest request) throws Exception {
        final BffApiProto.RequestBody body = request.getBody();
        final List<FieldMask> fieldMaskList = request.getFieldMaskList();

        // TODO: 2021/10/19 反序列化body为查询API格式
        BffApiDomain bffApiDomain = new BffApiDomain();

        for (FieldMask fieldMask : fieldMaskList) {
            // TODO: 2021/10/19 遍历获取每个API的参数
        }
    }
}
