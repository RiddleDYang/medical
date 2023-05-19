package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 检查项目组表，一个检查项目组中有多个检查项目
 * @date 2023/5/19 18:08
 */
@Entity
@Table(name = "t_check_group")
@Data
public class CheckGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 检查组编号
     */
    private String code;

    /**
     * 检查组名称
     */
    private String name;

    /**
     * 助记代码，方便医生输入。如：血常规，助记代码"XCG"
     */
    @Column(name = "help_code")
    private String helpCode;

    /**
     * 检查组适用性别，0为通用，1为男性适用，2为女性适用
     */
    private Character gender;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private String attention;

    /**
     * 和检查项目表是多对多关系
     */
    @ManyToMany(mappedBy = "checkGroups", cascade = CascadeType.PERSIST)
    private List<CheckItem> checkItems;

    /**
     * 和套餐表的多对多关系
     */
    @ManyToMany(mappedBy = "checkGroups", cascade = CascadeType.PERSIST)
    private List<SetMeal> setMeals;
}
