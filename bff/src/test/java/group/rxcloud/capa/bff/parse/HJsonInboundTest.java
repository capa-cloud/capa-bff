package group.rxcloud.capa.bff.parse;

import com.alibaba.fastjson.JSON;
import group.rxcloud.capa.bff.domain.CapaContext;
import group.rxcloud.capa.bff.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.inbound.HJsonInbound;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@DisplayName("请求体解析测试")
public class HJsonInboundTest {

    @Test
    public void testCase1() throws IOException {
        CapaContext context = new CapaContext();
        String requestStr = Files.readString(new ClassPathResource("hjson/old/case1.txt").getFile().toPath());
        List<HJsonInvocationRequest> inbound = new HJsonInbound().inbound(requestStr, context);

        String responseStr = Files.readString(new ClassPathResource("hjson/old/result1.txt").getFile().toPath());
        Assertions.assertEquals(JSON.toJSONString(inbound), responseStr);
    }

    @Test
    public void testCase2() throws IOException {
        CapaContext context = new CapaContext();
        String requestStr = Files.readString(new ClassPathResource("hjson/old/case2.txt").getFile().toPath());
        List<HJsonInvocationRequest> inbound = new HJsonInbound().inbound(requestStr, context);

        String responseStr = Files.readString(new ClassPathResource("hjson/old/result2.txt").getFile().toPath());
        Assertions.assertEquals(JSON.toJSONString(inbound), responseStr);
    }
}
