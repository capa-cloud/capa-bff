package parse;

import com.alibaba.fastjson.JSON;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.inbound.HJsonInbound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.HJsonInvocationRequestHelper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

@DisplayName("请求体解析测试")
public class HJsonInboundTest {
    private static final Map<String, List<HJsonInvocationRequest>> targetResultMap = new HashMap<>();

    static {
        List<HJsonInvocationRequest> case1 = new ArrayList<>();
        HJsonInvocationRequest getUserInfo = HJsonInvocationRequestHelper.builder("10011111", "getUserInfo")
                .buildMetadata("{}")
                .buildData("{\"id\": 1}")
                .buildResponseData("{\n" +
                        "          \"result.userInfo.id\": \"user.id\",\n" +
                        "          \"result.userInfo.name\": \"user.name\",\n" +
                        "          \"result.userInfo.age\" : \"user.age\"\n" +
                        "      }")
                .build();
        HJsonInvocationRequest getDepartmentInfoByUserId = HJsonInvocationRequestHelper.builder("10011111", "getDepartmentInfoByUserId")
                .buildMetadata("{}")
                .buildData("{\n" +
                        "        \"userId\": \"${user.id}\"\n" +
                        "      }")
                .buildResponseData("{\n" +
                        "        \"result.departmentInfo.name\" : \"user.departmentName\"\n" +
                        "      }")
                .build();
        case1.add(getUserInfo);
        case1.add(getDepartmentInfoByUserId);
        targetResultMap.put("case1", case1);
    }

    @Test
    public void testCase1() throws IOException {
        URL resource = getClass().getResource("hjson\\case1.txt");

        String readString = Files.readString(new File("hjson/case1.txt").toPath());
        List<HJsonInvocationRequest> inbound = new HJsonInbound().inbound(readString, null);
        for (int i = 0; i < inbound.size(); i++) {
            Assertions.assertEquals(inbound.get(i), targetResultMap.get("case1").get(i));
        }
    }
}
