package group.rxcloud.capa.bff.hjson.json;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class JsonValueMapper {

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
        }
        return object;
    }

    public static void main(String[] args) {
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
