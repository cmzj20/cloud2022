package com.cmzj21.springcloud.dao;

import com.cmzj21.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cmzj20
 */
@Mapper
public interface PaymentDao {
    /**
     * 插入一个元素
     * @param payment 被插入的元素
     * @return 影响行数
     */
    int create(Payment payment);

    /**
     * 根据id查询数据
     * @param id 查询的id号
     * @return 查询到的数据
     */
    Payment getPaymentById(@Param("id") Long id);

    /**
     * 获取全部的数据
     * @return 查询到的全部数据
     */
    List<Payment> getAllPayment();

    /**
     * 根据id更新数据库中的数据
     * @param payment 更新后的数据
     * @return 影响的行数
     */
    Integer updatePaymentById(Payment payment);

    /**
     * 根据id号删除数据
     * @param id id号
     * @return 影响的行数
     */
    Integer delPaymentById(@Param("id") Long id);
}
