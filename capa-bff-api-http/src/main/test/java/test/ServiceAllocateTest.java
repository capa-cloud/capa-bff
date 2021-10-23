package test;

import group.rxcloud.capa.bff.api.http.SpringBootBFFApplication;
import group.rxcloud.capa.bff.domain.Context;
import group.rxcloud.capa.bff.hjson.allocate.ServiceAllocate;
import group.rxcloud.capa.bff.hjson.domain.HJsonInvocationRequest;
import org.junit.jupiter.api.Test;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Author: KJ.ZHAO
 * Date: 2021/10/23 16:21
 */
@SpringBootTest(classes = SpringBootBFFApplication.class)
public class ServiceAllocateTest {

    @Autowired
    private ServiceAllocate serviceAllocate;

    @Test
    public void test(){
        serviceAllocate.invoke(Collections.singletonList(new HJsonInvocationRequest()), new Context() {
        });
    }
}
