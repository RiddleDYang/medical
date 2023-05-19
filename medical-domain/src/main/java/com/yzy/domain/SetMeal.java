package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 套餐表，与会员表是多对多关系，与订单表是一对多关系。多个订单对应一个套餐
 * @date 2023/5/19 18:42
 */
@Entity
@Table(name = "t_set_meal")
@Data
public class SetMeal {

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 套餐名称
     */
    private String name;

    /**
     * 套餐编号
     */
    private String code;

    /**
     * 套餐助记代码，如："入职体检"为"RZTJ"
     */
    @Column(name = "help_code")
    private String helpCode;

    /**
     * 套餐适用性别，0通用，1男性适用，2女性适用
     */
    private Character gender;

    /**
     * 套餐适用年龄段
     */
    private String age;

    /**
     * 套餐价格
     */
    private Float price;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 注意事项
     */
    private String attention;

    /**
     * 套餐配图的图片名称
     */
    private String img;

    /**
     * 和检查组表的多对多关系
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "t_set_meal_check_group",
        joinColumns = @JoinColumn(name = "set_meal_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "check_group_id", referencedColumnName = "id")
    )
    private List<CheckGroup> checkGroups;

    @OneToMany(mappedBy = "setMealId", cascade = CascadeType.PERSIST)
    private List<Order> orders ;
}
