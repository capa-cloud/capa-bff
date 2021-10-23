package group.rxcloud.capa.bff.api.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        scanBasePackages = {"group.rxcloud.capa.bff"}
)
public class SpringBootBFFApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBFFApplication.class, args);
    }
}
