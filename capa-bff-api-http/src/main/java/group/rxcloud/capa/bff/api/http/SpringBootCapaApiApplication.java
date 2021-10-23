package group.rxcloud.capa.bff.api.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangjun
 * @date 2021/10/23
 */
@SpringBootApplication(
        scanBasePackages = {"group.rxcloud.capa.bff"}
)
public class SpringBootCapaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCapaApiApplication.class, args);
    }
}
