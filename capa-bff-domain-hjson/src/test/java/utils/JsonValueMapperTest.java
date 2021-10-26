package utils;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.hjson.json.JsonValueMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangjun
 * @date 2021/10/26
 */
public class JsonValueMapperTest {

    public void test_replaceValuesByParameters() {
        JSONObject c = new JSONObject();
        c.put("int", "${user.id}");
        c.put("str", "${user.name}");

        JSONObject b = new JSONObject();
        b.put("c", c);

        JSONObject a = new JSONObject();
        a.put("b", b);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user.id", 1);
        parameters.put("user.name", "2");

        JSONObject jsonObject = JsonValueMapper.replaceValuesByParameters(a, parameters);

        JSONObject _c = jsonObject.getJSONObject("b").getJSONObject("c");
        Object _int = _c.get("int");
        Object _str = _c.get("str");

        System.out.println(_int);
        System.out.println(_str);

        assert Objects.equals(_int, 1);
        assert Objects.equals(_str, "2");
    }

    @Test
    public void test_findValueByPointPath() {
        JSONObject c = new JSONObject();
        c.put("int", 1);
        c.put("str", "2");

        JSONObject b = new JSONObject();
        b.put("c", c);

        JSONObject a = new JSONObject();
        a.put("b", b);

        Object _int = JsonValueMapper.findValueByPointPath(a, "b.c.int");
        Object _str = JsonValueMapper.findValueByPointPath(a, "b.c.str");

        System.out.println(_int);
        System.out.println(_str);

        assert Objects.equals(_int, 1);
        assert Objects.equals(_str, "2");
    }
}
