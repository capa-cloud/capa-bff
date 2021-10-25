package parse;

import com.alibaba.fastjson.JSON;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.inbound.HJsonInbound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import utils.HJsonInvocationRequestHelper;

import java.io.IOException;
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
        String requestStr = Files.readString(new ClassPathResource("hjson/case1.txt").getFile().toPath());
        List<HJsonInvocationRequest> inbound = new HJsonInbound().inbound(requestStr, null);

        String responseStr = Files.readString(new ClassPathResource("hjson/result1.txt").getFile().toPath());
        Assertions.assertEquals(JSON.toJSONString(inbound), responseStr);
    }

    @Test
    public void testCase2() throws IOException {
        String requestStr = Files.readString(new ClassPathResource("hjson/case2.txt").getFile().toPath());
        List<HJsonInvocationRequest> inbound = new HJsonInbound().inbound(requestStr, null);

        String responseStr = Files.readString(new ClassPathResource("hjson/result2.txt").getFile().toPath());
        Assertions.assertEquals(JSON.toJSONString(inbound), responseStr);
    }
}
