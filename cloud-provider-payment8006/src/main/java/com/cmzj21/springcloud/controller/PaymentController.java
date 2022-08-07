package com.cmzj21.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author cmzj21
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 用于验证consul是否配置成功
     * @return 验证配置成功的字符串
     */
    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "spring-cloud with consul: " + serverPort + "\t" + UUID.randomUUID();
    }
}
