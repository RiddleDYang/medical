package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 角色表，分别与用户表、权限表、菜单表都是多对多的关系
 * @date 2023/5/19 14:26
 */
@Data
@Entity
@Table(name = "t_role")
public class Role {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色关键字
     */
    private String keyword;

    /**
     * 角色描述信息
     */
    private String description;

    /**
     * 和用户表的多对多关系
     */
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.PERSIST})
    private List<User> users;

    /**
     * 和权限表的多对多关系
     */
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.PERSIST})
    private List<Permission> permissions;

    /**
     * 和菜单表的多对多关系
     */
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.PERSIST})
    private List<Menu> menus;
}
