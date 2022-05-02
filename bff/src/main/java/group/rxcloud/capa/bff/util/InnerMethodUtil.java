package group.rxcloud.capa.bff.util;

import com.alibaba.fastjson.JSONObject;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 21:52
 */
public class InnerMethodUtil {

    private static final HashMap<String, InnerInvokeMethod> methodMap;

    static {
        methodMap = new HashMap<>();
        methodMap.put("base64", (bytes) -> Base64.getEncoder().encode(bytes));
        methodMap.put("tostring", (bytes) -> bytes);
    }

    public static String runMethodAsStringBeforeConvert(String methodName, Object target) {
        if (target == null || methodName == null || !methodName.contains("#{") || !methodName.contains("}")
                || methodName.indexOf("}") < methodName.indexOf("#{")) {
            return "";
        }
        methodName = methodName.substring(methodName.indexOf("#{") + 2, methodName.indexOf("}"));
        if (methodMap.get(methodName.toLowerCase()) == null) {
            return JSONObject.toJSONString(target);
        }
        byte[] bytes = JSONObject.toJSONString(target).getBytes(StandardCharsets.UTF_8);
        return new String(methodMap.get(methodName.toLowerCase()).run(bytes), StandardCharsets.UTF_8);
    }

}
