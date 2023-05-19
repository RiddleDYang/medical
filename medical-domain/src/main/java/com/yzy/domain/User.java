package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 用户表，与角色表是多对多的关系
 * @date 2023/5/19 14:21
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户状态
     */
    private String station;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 维护和角色表的多对多关系
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "t_user_role",
        joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
                @JoinColumn(name = "role_id", referencedColumnName = "id")
        }
    )
    private List<Role> roles;

}
