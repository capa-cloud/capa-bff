package group.rxcloud.capa.bff.api.http.controller;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.domain.CapaContext;
import group.rxcloud.capa.bff.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.domain.HJsonInvocationResponse;
import group.rxcloud.capa.bff.inbound.HJsonInbound;
import group.rxcloud.capa.bff.invoke.HJsonInvoker;
import group.rxcloud.capa.bff.outbound.HJsonOutbound;
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
    public String checkhealth() {
        return "ok";
    }

    @RequestMapping(value = "/capabff")
    @ResponseBody
    public String bff(@RequestBody String request) {
        CapaContext context = new CapaContext();

        HJsonInbound hJsonInbound = new HJsonInbound();

        try {
            hJsonInbound.inbound(request, context);

            // todo: 能做成nio这种吗？
            // 将请求线程交给CAPA处理；然后这个请求线程可以去做其他的东西
            // 等到CAPA处理好了，再通知线程转交给用户
            context.start();

            return null;
        } catch (Exception e) {
            System.out.print("capabff.exception : " + e.getMessage());
            JSONObject exception = new JSONObject();
            exception.put("msg", e.getMessage());
            exception.put("code", "300");
            return exception.toJSONString();
        }
    }
//
//    @RequestMapping(value = "/capabff")
//    @ResponseBody
//    public String bff(@RequestBody String request) {
//        CapaContext context = new CapaContext();
//
//        HJsonInbound hJsonInbound = new HJsonInbound();
//        HJsonOutbound hJsonOutbound = new HJsonOutbound();
//
//        try {
//            List<HJsonInvocationRequest> hJsonInvocationRequests = hJsonInbound.inbound(request, context);
//            List<HJsonInvocationResponse> hJsonInvocationResponses = hJsonInvoker.invoke(hJsonInvocationRequests, context);
//            JSONObject outbound = hJsonOutbound.outbound(hJsonInvocationRequests, hJsonInvocationResponses, context);
//
//            return outbound.toJSONString();
//        } catch (Exception e) {
//            System.out.print("capabff.exception : " + e.getMessage());
//            JSONObject exception = new JSONObject();
//            exception.put("msg", e.getMessage());
//            exception.put("code", "300");
//            return exception.toJSONString();
//        }
//    }
}
