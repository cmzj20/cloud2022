package com.cmzj21.springcloud.controller;

import com.cmzj21.springcloud.entities.CommonResult;
import com.cmzj21.springcloud.entities.Payment;
import com.cmzj21.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    /**
     *
     * @return 执行的结果
     */
    @GetMapping("/payment/port")
    public String  port() {
        return serverPort;
    }

}
