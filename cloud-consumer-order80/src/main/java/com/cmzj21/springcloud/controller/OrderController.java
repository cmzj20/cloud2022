package com.cmzj21.springcloud.controller;

import com.cmzj21.springcloud.entities.CommonResult;
import com.cmzj21.springcloud.entities.Payment;
import com.cmzj21.springcloud.lb.LoadBalanceImpl;
import com.cmzj21.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    public static final String urlPath ="http://cloud-payment-service/";
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        log.info(payment.toString());
        return restTemplate.postForObject(urlPath+"payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(urlPath+"payment/get/"+id,CommonResult.class);
    }

    /**
     *
     * @return 执行的结果
     */
    @GetMapping("/consumer/payment/port")
    public String  port() {
        return restTemplate.getForObject(urlPath + "payment/port", String.class);
    }

    /**
     * 手写轮询算法
     * @return 访问的结果
     */
    @GetMapping("/consumer/payment/port1")
    public String  port1() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if(instances == null || instances.size() <= 0){
            return "没有可用服务";
        }
        ServiceInstance instance = loadBalancer.instances(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/port", String.class);
    }

}
