package com.cmzj21.springcloud.controller;

import com.cmzj21.springcloud.entities.CommonResult;
import com.cmzj21.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.cmzj21.springcloud.service.PaymentService;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        log.info(payment.toString());
        int i = paymentService.create(payment);
        if(i>0){
            return  new CommonResult<>(200,"插入成功port: "+serverPort,i);
        }else{
            return  new CommonResult<>(444,"插入失败port: "+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200, "查询成功port: " + serverPort, payment);
        }else{
            return  new CommonResult<>(444,"查询失败port: "+serverPort,null);
        }
    }

    @GetMapping("/payment/get")
    public CommonResult getAllPayment(){
        List<Payment> allPayment = paymentService.getAllPayment();
        if(allPayment!=null){
            return  new CommonResult<>(200,"查询所有成功port: "+serverPort,allPayment);
        }else{
            return  new CommonResult<>(444,"查询所有失败port: "+serverPort,null);
        }
    }

    @PutMapping("/payment/update")
    public CommonResult updatePaymentById(Payment payment){
        Integer integer = paymentService.updatePaymentById(payment);
        if(integer>0){
            return  new CommonResult<>(200,"更新成功port: "+serverPort,integer);
        }else{
            return  new CommonResult<>(444,"更新失败port: "+serverPort,null);
        }
    }
    @DeleteMapping("/payment/delete/{id}")
    public CommonResult delPaymentById(@PathVariable("id") Long id){
        Integer integer = paymentService.delPaymentById(id);
        if(integer>0){
            return  new CommonResult<>(200,"删除成功port: "+serverPort,integer);
        }else{
            return  new CommonResult<>(444,"删除失败port: "+serverPort,null);
        }
    }

    /**
     * 用于测试zookeeper是否成功连接部署
     * @return 返回一个字符串表示服务在zookeeper上成功部署
     */
    @GetMapping("/payment/zk")
    public String paymentZk() {
        return "spring-cloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID();
    }

}
