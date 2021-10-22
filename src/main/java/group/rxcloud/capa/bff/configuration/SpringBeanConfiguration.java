package group.rxcloud.capa.bff.configuration;

import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.capa.rpc.CapaRpcClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public CapaRpcClient capaRpcClient(){
        CapaRpcClient capaRpcClient = new CapaRpcClientBuilder().build();
        return capaRpcClient;
    }

    @Bean(value = "allocateThreadPool")
    public ThreadPoolExecutor threadPool(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20));
        return threadPool;
    }
}
