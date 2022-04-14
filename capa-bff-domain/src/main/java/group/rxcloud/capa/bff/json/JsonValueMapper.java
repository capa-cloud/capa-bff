package group.rxcloud.capa.bff.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.Map;

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
     *
     * @param jsonObject 原始的json对象
     * @param parameters 需要替换的参数
     * @return 替换成功后的json对象
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
        if (jsonString == null || jsonString.length() == 0) {
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
        return JSON.parseObject(jsonString);
    }

    private static String generateToken(String key) {
        return String.format(TOKEN, key);
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
     * @param jsonObject json对象
     * @param valuePath  要获取对象的路径
     * @return 该对象的值
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
        if (paths.length == 0) {
            return null;
        }

        Object object = null;
        JSONObject target = jsonObject;
        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            // 前N-1次遍历：获取JSON嵌套对象
            if (i < paths.length - 1) {
                target = target.getJSONObject(path);
            } else {
                // 第N次遍历：获取具体值
                object = target.get(path);
            }
            if (target == null) {
                return null;
            }
        }
        return object;
    }


    public static void replaceValueByRealPath(JSONObject response, String path, Object obj) {
        if (path == null || "*".equals(path)) {
            return;
        }
        String[] split = path.split("\\.");
        if (split.length == 0) {
            return;
        }
        int length = split.length;
        JSONObject pre = null;
        JSONObject next = response;
        String finalPath = "";
        for (int i = 0; i < length; i++) {
            finalPath = split[i];
            Object tmp = null;
            if ((tmp = next.get(split[i])) != null && tmp instanceof JSONObject) {
                pre = next;
                next = next.getJSONObject(split[i]);

            } else {
                pre = next;
                break;
            }

        }

        if (!StringUtils.isEmpty(finalPath)) {
            pre.put(finalPath, obj);
        }
    }
}
