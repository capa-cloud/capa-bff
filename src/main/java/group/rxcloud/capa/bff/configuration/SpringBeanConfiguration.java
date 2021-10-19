package group.rxcloud.capa.bff.configuration;

import group.rxcloud.capa.rpc.CapaRpcClient;
import group.rxcloud.capa.rpc.CapaRpcClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfiguration {

    @Bean
    public CapaRpcClient capaRpcClient(){
        CapaRpcClient capaRpcClient = new CapaRpcClientBuilder().build();
        return capaRpcClient;
    }
}
