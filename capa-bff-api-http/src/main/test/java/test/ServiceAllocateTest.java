package test;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.api.http.SpringBootCapaApiApplication;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.allocate.ServiceAllocate;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationResponse;
import org.junit.jupiter.api.Test;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 16:21
 */
@SpringBootTest(classes = SpringBootCapaApiApplication.class)
public class ServiceAllocateTest {

    @Autowired
    private ServiceAllocate serviceAllocate;

    @Test
    public void test(){
        HJsonInvocationRequest re = new HJsonInvocationRequest();
        JSONObject json = new JSONObject();
        json.put("name","张三");
        json.put("department","医院");
        re.setData(json);
        re.setAppId("110");
        re.setMethod("say");
        Map<String, Object> requireMap = new HashMap<>();
        requireMap.put("name","student.name");
        re.setRequiredParams(requireMap);

        System.out.println("request"+JSONObject.toJSONString(re));

        List<HJsonInvocationRequest> list = Collections.singletonList(re);

        List<HJsonInvocationResponse> invoke = serviceAllocate.invoke(list, new Context() {
        });
//        System.out.println(invoke);

        if (!CollectionUtils.isEmpty(invoke)){
            System.out.println("response"+JSONObject.toJSONString(invoke));

        }
    }
}
