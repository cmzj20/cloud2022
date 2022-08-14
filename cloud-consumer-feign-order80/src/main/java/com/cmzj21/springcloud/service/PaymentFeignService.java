package com.cmzj21.springcloud.service;

import com.cmzj21.springcloud.entities.CommonResult;
import com.cmzj21.springcloud.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cmzj21
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    /**
     * 插入一条数据
     * @param payment 插入的内容
     * @return 影响的行数
     */
    @PostMapping("/payment/create")
    CommonResult<Integer> create(@RequestBody Payment payment);

    /**
     * 查询一条数据
     * @param id id号
     * @return 查询的结果
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);


    /**
     * 返回访问的端口号
     * @return 返回端口号
     */
    @GetMapping("/payment/port")
    String  port();
}
