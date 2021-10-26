package utils;

import com.google.common.collect.ImmutableMap;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.util.GraphUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangjun
 * @date 2021/10/26
 */
public class GraphUtilTest {
    @Test
    public void hasNoCycle_test() {
        List<HJsonInvocationRequest> list = new ArrayList<>();

        HJsonInvocationRequest serviceA = getInvocationRequest("serviceA", null, ImmutableMap.of("name", "b.field"));
        HJsonInvocationRequest serviceB = getInvocationRequest("serviceB", ImmutableMap.of("b.field", ""), ImmutableMap.of("name", "c.field"));
        HJsonInvocationRequest serviceC = getInvocationRequest("serviceC", ImmutableMap.of("c.field", ""), ImmutableMap.of("name1", "d.field1", "name2", "d.field2"));
        HJsonInvocationRequest serviceD = getInvocationRequest("serviceD", ImmutableMap.of("c.field", "", "d.field1", "", "d.field2", ""), ImmutableMap.of("name1", "e.field"));
        HJsonInvocationRequest serviceE = getInvocationRequest("serviceE", ImmutableMap.of("e.field", ""), null);
        list.add(serviceA);
        list.add(serviceB);
        list.add(serviceC);
        list.add(serviceD);
        list.add(serviceE);
        GraphUtil g = new GraphUtil(list);
        g.find();
    }

    @Test
    public void hasCycle_test() {
        List<HJsonInvocationRequest> list = new ArrayList<>();

        HJsonInvocationRequest serviceA = getInvocationRequest("serviceA",  ImmutableMap.of("d.field1", ""), ImmutableMap.of("name", "b.field"));
        HJsonInvocationRequest serviceB = getInvocationRequest("serviceB", ImmutableMap.of("b.field", ""), ImmutableMap.of("name", "c.field"));
        HJsonInvocationRequest serviceC = getInvocationRequest("serviceC", ImmutableMap.of("c.field", ""), ImmutableMap.of("name1", "d.field1", "name2", "d.field2"));
        HJsonInvocationRequest serviceD = getInvocationRequest("serviceD", ImmutableMap.of("c.field", "", "d.field1", "", "d.field2", ""), ImmutableMap.of("name1", "e.field"));
        HJsonInvocationRequest serviceE = getInvocationRequest("serviceE", ImmutableMap.of("e.field", ""), null);
        list.add(serviceA);
        list.add(serviceB);
        list.add(serviceC);
        list.add(serviceD);
        list.add(serviceE);
        GraphUtil g = new GraphUtil(list);
        g.find();
    }

    @Test
    public void conflict_empty_test() {
        try {
            HJsonInvocationRequest serviceW = getInvocationRequest("serviceW", ImmutableMap.of("w.field", ""), null);
            HJsonInvocationRequest serviceA = getInvocationRequest("serviceA", null, ImmutableMap.of("name", "b.field"));
            HJsonInvocationRequest serviceB = getInvocationRequest("serviceB", ImmutableMap.of("b.field", ""), ImmutableMap.of("name", "c.field"));
            HJsonInvocationRequest serviceC = getInvocationRequest("serviceC", ImmutableMap.of("c.field", ""), ImmutableMap.of("name1", "d.field1", "name2", "d.field2"));
            HJsonInvocationRequest serviceD = getInvocationRequest("serviceD", ImmutableMap.of("c.field", "", "d.field1", "", "d.field2", ""), ImmutableMap.of("name1", "e.field"));
            HJsonInvocationRequest serviceE = getInvocationRequest("serviceE", ImmutableMap.of("e.field", ""), null);
            GraphUtil g = new GraphUtil(Lists.newArrayList(serviceW,serviceA,serviceB,serviceC,serviceD,serviceE));
            g.find();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void empty_test() {
        try {
            List<HJsonInvocationRequest> list = new ArrayList<>();
            HJsonInvocationRequest serviceA = getInvocationRequest("serviceA", ImmutableMap.of("b.field", ""), null);
            list.add(serviceA);
            GraphUtil g = new GraphUtil(list);
            g.find();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void hasCycle_myself_test() {
        try {
            List<HJsonInvocationRequest> list = new ArrayList<>();
            HJsonInvocationRequest serviceA = getInvocationRequest("serviceA", ImmutableMap.of("a.name", ""), ImmutableMap.of("name", "a.name"));
            list.add(serviceA);
            GraphUtil g = new GraphUtil(list);
            g.find();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private HJsonInvocationRequest getInvocationRequest(String serviceName, Map<String, Object> requireMap, Map<String, String> responseMap) {
        HJsonInvocationRequest service02 = new HJsonInvocationRequest();
        service02.setAppId(serviceName);
        service02.setResponseDataFormat(responseMap);
        service02.setRequiredParams(requireMap);
        return service02;
    }
}
