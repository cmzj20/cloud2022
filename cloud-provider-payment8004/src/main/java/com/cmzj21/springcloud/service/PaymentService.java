package com.cmzj21.springcloud.service;

import com.cmzj21.springcloud.entities.Payment;

import java.util.List;

/**
 * @author cmzj21
 */
public interface PaymentService {
    /**
     * 增
     * @param payment 插入的信息
     * @return 影响的行数
     */
    int create(Payment payment);

    /**
     * 查
     * @param id id号
     * @return 员工信息
     */
    Payment getPaymentById(Long id);

    /**
     * 查所有
     * @return 全部员工信息
     */
    List<Payment> getAllPayment();

    /**
     * 改
     * @param payment 修改后的信息
     * @return 影响行数
     */
    Integer updatePaymentById(Payment payment);

    /**
     * 删除
     * @param id id号
     * @return 影响行数
     */
    Integer delPaymentById(Long id);
}
