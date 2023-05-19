package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 订单表，和套餐表、会员表是多对一的关系。一个套餐对应多个订单，一个会员对应多个订单
 * @date 2023/5/19 19:49
 */

@Entity
@Table(name = "t_order")
@Data
public class Order {

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会员id，外键，关联到会员表主键，维护多对一的关系
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member memberId;

    /**
     * 预约日期
     */
    @Column(name = "order_date")
    private Date orderDate;

    /**
     * 订单类型：电话预约、微信预约
     */
    @Column(name = "order_type")
    private String orderType;

    /**
     * 预约状态（是否到诊）
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 套餐id，外键，关联到套餐表的主键
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "set_meal_id", referencedColumnName = "id")
    private SetMeal setMealId;

}
