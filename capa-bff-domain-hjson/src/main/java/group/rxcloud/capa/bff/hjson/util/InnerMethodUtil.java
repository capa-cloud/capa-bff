package group.rxcloud.capa.bff.hjson.util;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 21:52
 */
public class InnerMethodUtil {
    private static final HashMap<String,InnerInvokeMethod> methodMap;


    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("name","lsadkjaskd");
        String base64 = runMethodAsStringBeforeConvert("#{Base64} user.code", json);
        System.out.println(base64);
        System.out.println(new String(Base64.getDecoder().decode(base64)));
    }
    static {
        methodMap = new HashMap<>();
        methodMap.put("Base64",(bytes)->{
            return Base64.getEncoder().encode(bytes);
        });
    }

    public static  String runMethodAsStringBeforeConvert(String methodName,Object target){
        if (target==null || methodName==null|| !methodName.contains("#{") || !methodName.contains("}")
        || methodName.indexOf("}")< methodName.indexOf("#{")){
            return "";
        }
        methodName = methodName.substring(methodName.indexOf("#{")+2,methodName.indexOf("}"));
        if ( methodMap.get(methodName)==null){
            return JSONObject.toJSONString(target);
        }
        byte[] bytes = JSONObject.toJSONString(target).getBytes(StandardCharsets.UTF_8);
        return new String(methodMap.get(methodName).run(bytes));
    }
}
