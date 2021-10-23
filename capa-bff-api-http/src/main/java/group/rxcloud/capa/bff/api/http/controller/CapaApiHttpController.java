package group.rxcloud.capa.bff.api.http.controller;

import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.inbound.HJsonInbound;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author wangjun
 * @date 2021/10/23
 */
@Controller
public class CapaApiHttpController {

    @RequestMapping(value = "/capabff")
    public @ResponseBody String bff(@RequestBody String request) throws Exception {
        HJsonInbound hJsonInbound = new HJsonInbound();
        List<HJsonInvocationRequest> inbound = hJsonInbound.inbound(request, null);
        //
        return toJSONString(request);
    }
}
