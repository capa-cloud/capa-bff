package group.rxcloud.capa.bff.api.http.controller;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.hjson.invoke.HJsonInvoker;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.hjson.inbound.HJsonInbound;
import group.rxcloud.capa.bff.hjson.outbound.HJsonOutbound;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wangjun
 * @date 2021/10/23
 */
@Controller
public class CapaApiHttpController {

    @Resource
    private HJsonInvoker hJsonInvoker;

    @RequestMapping(value = "/capabff")
    public @ResponseBody String bff(@RequestBody String request) throws Exception {
        HJsonInbound hJsonInbound = new HJsonInbound();
        List<HJsonInvocationRequest> hJsonInvocationRequests = hJsonInbound.inbound(request, null);
        List<HJsonInvocationResponse> hJsonInvocationResponses = hJsonInvoker.invoke(hJsonInvocationRequests, null);
        JSONObject outbound = new HJsonOutbound().outbound(hJsonInvocationRequests, hJsonInvocationResponses, null);

        return outbound.toJSONString();
    }
}
