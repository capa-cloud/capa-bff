package group.rxcloud.capa.bff.hjson.util;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import group.rxcloud.capa.bff.hjson.json.JsonValueMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 21:52
 */
public class InnerMethodUtil {
    private static final HashMap<String,InnerInvokeMethod> methodMap;


    public static void main(String[] args) {
//        JSONObject json = new JSONObject();
//        json.put("name","lsadkjaskd");
//        String base64 = runMethodAsStringBeforeConvert("#{Base64} user.code", json);
//        System.out.println(base64);
//        System.out.println(new String(Base64.getDecoder().decode(base64)));


        JSONObject j = new JSONObject();
        j.put("name","zhangsan");
        j.put("age",12);
        JSONObject com = new JSONObject();
        com.put("name","xiehcneg");
        j.put("company",com);
        System.out.println("original: "+j);
        JSONObject com2 = new JSONObject();
        JSONObject depart01 = new JSONObject();
        depart01.put("dName","depart01");
        com.put("depart",depart01);
        com2.put("name","xiehcneg222");

        JsonValueMapper.replaceValueByRealPath(j,"company",com2);
        System.out.println("first :"+j);

        JsonValueMapper.replaceValueByRealPath(j,"company.name"," nmnmn");
        System.out.println("second: "+j);
    }
    static {
        methodMap = new HashMap<>();
        methodMap.put("Base64",(bytes)->{
            return Base64.getEncoder().encode(bytes);
        });

        methodMap.put("ToString",(bytes)->{
            return bytes;
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
