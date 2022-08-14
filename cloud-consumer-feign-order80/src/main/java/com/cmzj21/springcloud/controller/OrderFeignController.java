package com.cmzj21.springcloud.controller;

import com.cmzj21.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cmzj21
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 返回访问的端口号
     * @return 执行的结果
     */
    @GetMapping("/consumer/payment/port")
    public String  port() {
        return paymentFeignService.port();
    }
}
