package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 会员表与订单表是一对多关系。一个会员有多个订单
 * @date 2023/5/19 18:42
 */
@Entity
@Table(name = "t_member")
@Data
public class Member {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件编号
     */
    private String fileNumber;

    /**
     * 会员姓名
     */
    private String name;

    /**
     * 会员性别，1男性，2女性
     */
    private Character gender;

    /**
     * 会员卡号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 和订单表是一对多的关系
     * 订单表外键关联本表主键
     */
    @OneToMany(mappedBy = "memberId", cascade = CascadeType.PERSIST)
    private List<Order> orders;

}