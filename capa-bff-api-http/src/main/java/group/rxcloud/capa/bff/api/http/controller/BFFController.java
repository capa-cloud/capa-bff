package group.rxcloud.capa.bff.api.http.controller;

import group.rxcloud.capa.rpc.CapaRpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BFFController {
    @Autowired
    private CapaRpcClient capaRpcClient;

    @RequestMapping(value = "/capabff", method = RequestMethod.POST, produces = "application/x-protobuf")
    public @ResponseBody String bff(String request) throws Exception {
        return null;
    }
}
