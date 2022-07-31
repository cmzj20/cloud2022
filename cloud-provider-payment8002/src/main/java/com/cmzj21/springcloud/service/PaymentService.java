package com.cmzj21.springcloud.service;

import com.cmzj21.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {
    //增
    int create(Payment payment);
    //查
    Payment getPaymentById(Long id);
    List<Payment> getAllPayment();
    //改
    Integer updatePaymentById(Payment payment);
    //删
    Integer delPaymentById(Long id);
}
