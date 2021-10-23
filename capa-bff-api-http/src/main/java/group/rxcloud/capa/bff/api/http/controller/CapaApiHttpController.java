package group.rxcloud.capa.bff.api.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * @author wangjun
 * @date 2021/10/23
 */
@Controller
public class CapaApiHttpController {

    @RequestMapping(value = "/capabff")
    public @ResponseBody String bff(String request) throws Exception {
        return toJSONString(request);
    }
}
