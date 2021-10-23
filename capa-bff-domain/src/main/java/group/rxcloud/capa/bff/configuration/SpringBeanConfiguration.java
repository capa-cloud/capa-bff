package group.rxcloud.capa.bff.configuration;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.capa.rpc.CapaRpcClientBuilder;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.domain.core.invocation.InvokeMethodRequest;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Map;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public CapaRpcClient capaRpcClient() {
//        CapaRpcClient capaRpcClient = new MyTmpCapaRpcClient();
        CapaRpcClient capaRpcClient =new CapaRpcClientBuilder().build();
        return capaRpcClient;
    }

    class MyTmpCapaRpcClient implements CapaRpcClient{

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, Object data, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
            JSONObject res = new JSONObject();
            if (data instanceof JSONObject){
                res.put("name","zhangsan");
                res.put("age",15);
            }else {
                res.put("mes","errr!!!!");
            }
            return Mono.just((T)res);
        }

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
            return null;
        }

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, TypeRef<T> type) {
            return null;
        }

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Class<T> clazz) {
            return null;
        }

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {
            return null;
        }

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata, Class<T> clazz) {
            return null;
        }

        @Override
        public Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension, Map<String, String> metadata) {
            return null;
        }

        @Override
        public Mono<Void> invokeMethod(String appId, String methodName, Object request, HttpExtension httpExtension) {
            return null;
        }

        @Override
        public Mono<Void> invokeMethod(String appId, String methodName, HttpExtension httpExtension, Map<String, String> metadata) {
            return null;
        }

        @Override
        public Mono<byte[]> invokeMethod(String appId, String methodName, byte[] request, HttpExtension httpExtension, Map<String, String> metadata) {
            return null;
        }

        @Override
        public <T> Mono<T> invokeMethod(InvokeMethodRequest invokeMethodRequest, TypeRef<T> type) {
            return null;
        }

        @Override
        public void close() {

        }
    }
}
