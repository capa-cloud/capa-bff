package integration;

import com.github.kevinsawicki.http.HttpRequest;
import group.rxcloud.capa.bff.api.http.SpringBootCapaApiApplication;
import group.rxcloud.capa.bff.api.http.controller.CapaApiHttpController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import javax.annotation.Resource;
import java.io.File;

//@SpringBootTest(classes = SpringBootCapaApiApplication.class )
public class IntegrationTest {

    @Resource
    private CapaApiHttpController capaApiHttpController;


//    @Test
    public void test() throws Exception {
        // 先启动依赖服务端项目
        ProcessBuilder pb = new ProcessBuilder("sh", "test.sh")
                .directory(new File(System.getProperty("user.dir")).getParentFile())
                .inheritIO();
        Process start = pb.start();
        Thread.sleep(10 * 1000);

        String requestParam = "{\n" +
                "  \"http://localhost:8082\": [\n" +
                "    \"/api/v1/pet\":(\n" +
                "      request: {\n" +
                "          \n" +
                "       }, \n" +
                "      response: {\n" +
                "          \"id\": \"id\"\n" +
                "\n" +
                "      }\n" +
                "    )\n" +
                "  ]\n" +
                "}";
        String bff = capaApiHttpController.bff(requestParam);
        System.out.println("body = " + bff);

        String send = HttpRequest.post("http://localhost:8082/api/v1/pet")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body();
        System.out.println("send = " + send);


        Runtime.getRuntime().exec(new String[]{"sh", "kill -9 " + start.pid()});
    }
}
