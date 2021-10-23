package group.rxcloud.capa.bff.api.http;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wangjun
 */
@SpringBootApplication(scanBasePackages = "group.rxcloud.capa.bff")
@ServletComponentScan
public class WebInitializer extends SpringBootServletInitializer {

    /**
     * Configure your application when it’s launched by the servlet container
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebInitializer.class);
    }
}

