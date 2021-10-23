package group.rxcloud.capa.bff.hjson.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonValueMapper {

    /**
     * HJson格式使用{@code ${%s}}格式作为占位符
     */
    private static final String TOKEN = "\\$\\{%s\\}";

    public static String[] findValueByPointPath(String valuePath) {
        if (valuePath == null || valuePath.length() == 0) {
            return null;
        }

        // 解析PointPath{a.b.c}路径格式
        String[] paths = valuePath.split("\\.");
        if (paths == null || paths.length == 0) {
            return null;
        }

        return paths;
    }

    /**
     * 使用Parameters{@code <别名，值>}中的值，替换JSONObject中的占位符
     */
    public static JSONObject replaceValuesByParameters(JSONObject jsonObject, Map<String, Object> parameters) {
        if (jsonObject == null) {
            return null;
        }
        if (parameters == null || parameters.isEmpty()) {
            return jsonObject;
        }

        // 先把JsonObject转成Json字符串
        String jsonString = jsonObject.toJSONString();
        if (jsonObject == null || jsonString.length() == 0) {
            return jsonObject;
        }

        // 使用字符串替换，把占位符替换掉
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            final String key = entry.getKey();
            final Object value = entry.getValue();

            String token = generateToken(key);
            String tokenValue = generateTokenValue(value);
            jsonString = jsonString.replaceAll(token, tokenValue);
        }

        // 把替换后的Json字符串，反序列化成JSONObject对象
        JSONObject parseObject = JSON.parseObject(jsonString);
        return parseObject;
    }

    private static String generateToken(String key) {
        String token = String.format(TOKEN, key);
        return token;
    }

    private static String generateTokenValue(Object value) {
        String tokenValue;
        if (value instanceof String) {
            tokenValue = String.valueOf(value);
        } else {
            tokenValue = JSON.toJSONString(value);
        }
        return tokenValue;
    }

    /**
     * 根据PointPath{a.b.c}路径格式，从JSONObject中获取指定的路径项的值
     *
     * @return null when not found
     */
    public static Object findValueByPointPath(JSONObject jsonObject, String valuePath) {
        if (jsonObject == null) {
            return null;
        }
        if (valuePath == null || valuePath.length() == 0) {
            return null;
        }

        // 解析PointPath{a.b.c}路径格式
        String[] paths = valuePath.split("\\.");
        if (paths == null || paths.length == 0) {
            return null;
        }

        Object object = null;
        JSONObject target = jsonObject;
        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            // 前N-1次遍历：获取JSON嵌套对象
            if (i < paths.length - 1) {
                target = target.getJSONObject(path);
            }
            // 第N次遍历：获取具体值
            else {
                object = target.get(path);
            }
            if (target == null) {
                return null;
            }
        }
        return object;
    }

    public static void main(String[] args) {
        test_replaceValuesByParameters();
        test_findValueByPointPath();
    }

    private static void test_replaceValuesByParameters() {
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

    private static void test_findValueByPointPath() {
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
