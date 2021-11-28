package group.rxcloud.capa.bff.api.http.integration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.api.http.controller.CapaApiHttpController;
import group.rxcloud.capa.bff.hjson.json.JsonValueMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SpringBootCapaApiApplicationTests {

    @Resource
    private CapaApiHttpController capaApiHttpController;


    @Test
    public void test() throws Exception {

        String requestParam = "{\n" +
                "  \"http://127.0.0.1:8089\": [\n" +
                "    \"/api/v1/pet\":(\n" +
                "      request: {\n" +
                "          \n" +
                "       }, \n" +
                "      response: {\n" +
                "          \"id\": \"id\"\n" +
                "\n" +
                "      }\n" +
                "    )\n" +
                "  ]\n" +
                "}";
        String bff = capaApiHttpController.bff(requestParam);
        JSONObject response = JSON.parseObject(bff);
        JSONArray obj = (JSONArray) JsonValueMapper.findValueByPointPath(response, "errors");
        Assertions.assertEquals(0, obj.size());



    }
}
