package com.cmzj21.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自己写的负载均衡轮训算法业务类
 * @author cmzj21
 */
@Component
public class LoadBalanceImpl implements LoadBalancer{

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            //CAS
            if (nextServerCyclicCounter.compareAndSet(current, next)) {
                System.out.println("*******第几次访问next：" + next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int next = incrementAndGetModulo(serviceInstanceList.size());
        return serviceInstanceList.get(next);
    }
}
