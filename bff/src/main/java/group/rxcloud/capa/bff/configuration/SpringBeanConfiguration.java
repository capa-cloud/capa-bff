package group.rxcloud.capa.bff.configuration;

import com.alibaba.fastjson.JSONObject;
import group.rxcloud.capa.infrastructure.serializer.DefaultObjectSerializer;
import group.rxcloud.capa.infrastructure.serializer.ObjectSerializer;
import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.cloudruntimes.domain.core.invocation.HttpExtension;
import group.rxcloud.cloudruntimes.domain.core.invocation.InvokeMethodRequest;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import javax.annotation.Resource;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Configuration
public class SpringBeanConfiguration {

    @Component
    public static class HttpInvokeClient {

        private final HttpClient client;

        public HttpInvokeClient() {
            client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(60))
                    .build();
        }

        public CompletableFuture<HttpResponse<byte[]>> send(String url, String json) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .build();
            return client.sendAsync(request, HttpResponse.BodyHandlers.ofByteArray());
        }
    }

    @Component
    public static class TempCapaRpcClient implements CapaRpcClient {

        @Resource
        private HttpInvokeClient httpInvokeClient;

        private final ObjectSerializer objectSerializer = new DefaultObjectSerializer();

        @Override
        public <T> Mono<T> invokeMethod(String appId, String methodName, Object data, HttpExtension httpExtension, Map<String, String> metadata, TypeRef<T> type) {

            String serviceMeshHttpUrl = appId + methodName;
            // 目前只有HJson一种实现，所以先写死成JSONObject
            if (data instanceof JSONObject) {
                String json = ((JSONObject) data).toJSONString();
                System.out.println("invokeMethod request:" + json);

                CompletableFuture<HttpResponse<byte[]>> completableFuture = httpInvokeClient.send(serviceMeshHttpUrl, json);
                CompletableFuture<T> byteFuture = completableFuture.thenApply(httpResponse -> {
                    final byte[] httpResponseBody = httpResponse.body();
                    System.out.println("invokeMethod response:" + new String(httpResponseBody, StandardCharsets.UTF_8));
                    try {
                        return objectSerializer.deserialize(httpResponseBody, type);
                    } catch (Exception e) {
                        System.out.println("[ERROR] invokeMethod exception" + e);
                        return null;
                    }
                });
                return Mono.fromCompletionStage(byteFuture);
            }
            throw new RuntimeException("[ERROR] invokeMethod only supported JSONObject");
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
