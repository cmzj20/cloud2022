package com.cmzj21.springcloud.service.impl;

import com.cmzj21.springcloud.dao.PaymentDao;
import com.cmzj21.springcloud.entities.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cmzj21.springcloud.service.PaymentService;

import java.util.List;

/**
 * 处理消费者的服务
 * @author cmzj21
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentDao.getAllPayment();
    }

    @Override
    public Integer updatePaymentById(Payment payment) {
        return paymentDao.updatePaymentById(payment);
    }

    @Override
    public Integer delPaymentById(Long id) {
        return paymentDao.delPaymentById(id);
    }
}
