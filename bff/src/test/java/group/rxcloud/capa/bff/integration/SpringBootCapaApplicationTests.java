package group.rxcloud.capa.bff.integration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import group.rxcloud.capa.bff.controller.CapaApiHttpController;
import group.rxcloud.capa.bff.json.JsonValueMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;

@SpringBootTest
public class SpringBootCapaApplicationTests {

    @Resource
    private CapaApiHttpController capaApiHttpController;

    @Test
    @DisplayName("简单情况测试")
    public void simpleCase() throws IOException {
        commonTest(1);
    }

    @Test
    @DisplayName("简单结果全匹配测试")
    public void simpleAllMatchCase() throws IOException {
        commonTest(2);
    }

    @Test
    @DisplayName("复杂嵌套测试")
    public void hardInnerCase() throws IOException {
        commonTest(3);
    }

    private void commonTest(int i) throws IOException {
        String requestParam = Files.readString(new ClassPathResource(String.format("hjson/request%d.txt", i)).getFile().toPath());
        String responseStr = Files.readString(new ClassPathResource(String.format("hjson/response%d.txt", i)).getFile().toPath());
        String bff = capaApiHttpController.bff(requestParam);
        Assertions.assertTrue(isJsonEqual(responseStr, bff));
        JSONObject response = JSON.parseObject(bff);
        JSONArray obj = (JSONArray) JsonValueMapper.findValueByPointPath(response, "errors");
        Assertions.assertEquals(0, obj.size());
    }

    private static boolean isJsonEqual(String jsonStr1, String jsonStr2) {
        JsonObject obj = (JsonObject) new JsonParser().parse(jsonStr1);
        JsonObject obj1 = (JsonObject) new JsonParser().parse(jsonStr2);
        return obj.equals(obj1);
    }
}
