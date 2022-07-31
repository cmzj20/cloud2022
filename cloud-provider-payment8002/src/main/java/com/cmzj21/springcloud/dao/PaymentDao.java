package com.cmzj21.springcloud.dao;

import com.cmzj21.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
    //增
    int create(Payment payment);
    //查
    Payment getPaymentById(@Param("id") Long id);
    List<Payment> getAllPayment();
    //改
    Integer updatePaymentById(Payment payment);
    //删
    Integer delPaymentById(@Param("id") Long id);
}
