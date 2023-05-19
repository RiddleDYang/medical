package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 菜单表，与角色表是多对多的关系
 * @date 2023/5/19 14:34
 */
@Data
@Entity
@Table(name = "t_menu")
public class Menu {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单对应的页面的名称
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 目录路径
     */
    private String path;

    /**
     * 目录优先级
     */
    private String priority;

    /**
     * 页面中的菜单项logo名称
     */
    private String icon;

    /**
     * 菜单描述
     */
    private String description;

    /**
     * 当前菜单对应的父级菜单
     */
    @JoinColumn(name = "parent_menu_id")
    @ManyToOne
    private Menu parentMenuId;

    /**
     * 设置自关联
     */
    @OneToMany(mappedBy = "parentMenuId")
    private List<Menu> child;

    /**
     * 目录级别
     */
    private String level;


    /**
     * 维护和角色表的多对多关系
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "t_role_menu",
            joinColumns = {
                    @JoinColumn(name = "menu_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    private List<Role> roles;


}
