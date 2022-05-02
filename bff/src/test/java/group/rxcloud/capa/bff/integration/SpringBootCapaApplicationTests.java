package group.rxcloud.capa.bff.integration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.controller.CapaApiHttpController;
import group.rxcloud.capa.bff.json.JsonValueMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringBootCapaApplicationTests {

    @Resource
    private CapaApiHttpController capaApiHttpController;

    private static final List<String> requestStrList = new ArrayList<>();

    private static final List<String> responseStrList = new ArrayList<>();

    static {
        String responseStr = "{\"body\":{\"id\":1},\"errors\":[]}";
        responseStrList.add(responseStr);
        responseStr = "{\"body\":{\"resultInfo\":{\"data\":[{\"name\":\"test1\",\"id\":1},{\"name\":\"test2\",\"id\":2},{\"name\":\"test3\",\"id\":3},{\"name\":\"test4\",\"id\":4},{\"name\":\"test5\",\"id\":5},{\"name\":\"test6\",\"id\":6},{\"name\":\"test7\",\"id\":7},{\"name\":\"test8\",\"id\":8},{\"name\":\"test9\",\"id\":9},{\"name\":\"test10\",\"id\":10}],\"status\":200}},\"errors\":[]}";
        responseStrList.add(responseStr);
        responseStr = "{\"body\":{\"resultInfo\":{\"id\":1,\"pet\":{\"name\":\"test1\",\"id\":1}}},\"errors\":[]}";
        responseStrList.add(responseStr);
    }

    static {
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
        requestStrList.add(requestParam);
        requestParam = "{\n" +
                "  \"http://localhost:8089\": [\n" +
                "    \"/api/v1/list\": (\n" +
                "      request: {}, \n" +
                "      response: {\n" +
                "            \"*\" : \"resultInfo\" \n" +
                "      }\n" +
                "    )\n" +
                "  ]\n" +
                "}";
        requestStrList.add(requestParam);
        requestParam = "{\n" +
                "  \"http://localhost:8089\": [\n" +
                "    \"/api/v1/pet\": (\n" +
                "      request: {}, \n" +
                "      response: {\n" +
                "            \"id\" : \"resultInfo.id\" \n" +
                "      }\n" +
                "    ),\n" +
                "    \"/api/v1/id\": (\n" +
                "      request: {\n" +
                "          \"id\": \"${resultInfo.id}\"\n" +
                "      }, \n" +
                "      response: {\n" +
                "            \"*\" : \"resultInfo.pet\" \n" +
                "      }\n" +
                "    )\n" +
                "  ]\n" +
                "}";
        requestStrList.add(requestParam);
    }

    @Test
    public void test() throws InterruptedException {

        // 等待测试依赖项目启动
        Thread.sleep(10 * 1000);

        for (int i = 0; i < requestStrList.size(); i++) {
            String requestParam = requestStrList.get(i);
            String bff = capaApiHttpController.bff(requestParam);
            String responseStr = responseStrList.get(i);
            Assertions.assertEquals(responseStr, bff);
            JSONObject response = JSON.parseObject(bff);
            JSONArray obj = (JSONArray) JsonValueMapper.findValueByPointPath(response, "errors");
            Assertions.assertEquals(0, obj.size());
        }

    }
}
