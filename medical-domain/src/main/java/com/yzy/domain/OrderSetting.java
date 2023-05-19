package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author Riddle
 * @version 1.0
 * @description 预约排期表，根据日历设置每天的可预约情况，并保存已预约记录
 * @date 2023/5/19 22:14
 */
@Entity
@Table(name = "t_order_setting")
@Data
public class OrderSetting {

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 预约日期
     */
    @Column(name = "order_date")
    private Date orderDate;

    /**
     * 可预约人数
     */
    private Integer number;

    /**
     * 已预约人数
     */
    private Integer reservations;
}
