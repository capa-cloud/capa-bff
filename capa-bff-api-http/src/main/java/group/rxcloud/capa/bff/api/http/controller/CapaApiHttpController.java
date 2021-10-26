package group.rxcloud.capa.bff.api.http.controller;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.DefaultContext;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.hjson.inbound.HJsonInbound;
import group.rxcloud.capa.bff.hjson.invoke.HJsonInvoker;
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

    @RequestMapping(value = "/vi/health")
    @ResponseBody
    public String checkhealth(){
        return "ok";
    }

    @RequestMapping(value = "/capabff")
    public @ResponseBody String bff(@RequestBody String request) {
        DefaultContext context = new DefaultContext();

        HJsonInbound hJsonInbound = new HJsonInbound();
        HJsonOutbound hJsonOutbound = new HJsonOutbound();

        try {
            List<HJsonInvocationRequest> hJsonInvocationRequests = hJsonInbound.inbound(request, context);
            List<HJsonInvocationResponse> hJsonInvocationResponses = hJsonInvoker.invoke(hJsonInvocationRequests, context);
            JSONObject outbound = hJsonOutbound.outbound(hJsonInvocationRequests, hJsonInvocationResponses, context);

            return outbound.toJSONString();
        } catch (Exception e) {
            System.out.printf("capabff.exception : " + e.getMessage());
            JSONObject exception = new JSONObject();
            exception.put("msg", e.getMessage());
            exception.put("code", "300");
            return exception.toJSONString();
        }
    }
}
