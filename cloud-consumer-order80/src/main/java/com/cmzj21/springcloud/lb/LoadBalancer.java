package com.cmzj21.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;


import java.util.List;

/**
 * @author cmzj21
 */
public interface LoadBalancer {
    /**
     * 用轮训算法选择一个服务
     * @param serviceInstanceList 要求选择的服务列表
     * @return 选择到的服务
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
