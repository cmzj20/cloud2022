package com.cmzj21.springcloud.dao;

import com.cmzj21.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
    /**
     * 添加
     * @param payment 插入的数据
     * @return 影响的行数
     */
    int create(Payment payment);

    /**
     * 查询
     * @param id id号
     * @return 查询到的结果
     */
    Payment getPaymentById(@Param("id") Long id);
    List<Payment> getAllPayment();

    /**
     * 修改
     * @param payment 更新后的内容
     * @return 影响的行数
     */
    Integer updatePaymentById(Payment payment);

    /**
     * 删除
     * @param id 删除的id号
     * @return 影响的行数
     */
    Integer delPaymentById(@Param("id") Long id);
}
