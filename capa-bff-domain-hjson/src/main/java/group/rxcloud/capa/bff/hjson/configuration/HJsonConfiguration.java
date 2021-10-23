package group.rxcloud.capa.bff.hjson.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class HJsonConfiguration {

    @Bean(value = "allocateThreadPool")
    public ThreadPoolExecutor threadPool() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        return threadPool;
    }
}
