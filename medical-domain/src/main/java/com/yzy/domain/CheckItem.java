package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 检查项目表，和检查项目组表是多对多关系
 * @date 2023/5/19 18:01
 */
@Data
@Entity
@Table(name = "t_check_item")
public class CheckItem {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 检查项编号
     */
    private String code;

    /**
     * 检查项名称
     */
    private String name;

    /**
     * 检查项适用性别，0为通用，1为男性适用，2为女性适用
     */
    private Character gender;

    /**
     * 检查项适用年龄范围
     */
    private String age;

    /**
     * 检查项单价
     */
    private Float price;

    /**
     * 检查项类型，分为：检查（1 表示）、检验（2 表示）两种
     */
    private Character type;

    /**
     * 检查项注意事项
     */
    private String attention;

    /**
     * 检查项备注信息
     */
    private String remark;

    /**
     * 维护和检查项目组表的多对多关系
     */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
        name = "t_check_item_check_group",
        joinColumns = {@JoinColumn(name = "check_item_id",referencedColumnName = "id")},
        inverseJoinColumns ={@JoinColumn(name = "check_group_id",referencedColumnName = "id")}
    )
    private List<CheckGroup> checkGroups;
}
