package group.rxcloud.capa.bff.utils;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.net.URL;

public class JsonDataSource {


    public <T> T getData(String fileName, Class<T> clazz) {
        URL resource = getClass().getResource(fileName);
        if (resource == null) {
            return null;
        }
        String readString;
        try {
            readString = ResourceUtils.readUrlAsString(resource);
        } catch (IOException e) {
            return null;
        }
        return JSONObject.parseObject(readString, clazz);
    }


}
