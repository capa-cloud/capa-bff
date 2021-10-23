package group.rxcloud.capa.bff.hjson.json;

import com.alibaba.fastjson.JSONObject;

public class JsonValueMapper {

    public static Object findValueByPointPath(JSONObject jsonObject, String valuePath) {
        if (jsonObject == null) {
            return null;
        }
        if (valuePath == null || valuePath.length() == 0) {
            return null;
        }

        String[] paths = valuePath.split("\\.");
        if (paths == null || paths.length == 0) {
            return null;
        }

        Object object = null;
        JSONObject target = jsonObject;
        for (int i = 0; i < paths.length; i++) {
            if (i < paths.length - 1) {
                String path = paths[i];
                target = target.getJSONObject(path);
            } else {
                object = target.get(paths[paths.length - 1]);
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
    }
}
