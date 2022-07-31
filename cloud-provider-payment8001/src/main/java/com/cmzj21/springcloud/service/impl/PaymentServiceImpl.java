package com.cmzj21.springcloud.service.impl;

import com.cmzj21.springcloud.dao.PaymentDao;
import com.cmzj21.springcloud.entities.Payment;
import com.cmzj21.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }

    @Override
    public List<Payment> getAllPayment() {
        List<Payment> allPayment = paymentDao.getAllPayment();
        return allPayment;
    }

    @Override
    public Integer updatePaymentById(Payment payment) {
        Integer integer = paymentDao.updatePaymentById(payment);
        return integer;
    }

    @Override
    public Integer delPaymentById(Long id) {
        Integer integer = paymentDao.delPaymentById(id);
        return integer;
    }
}
