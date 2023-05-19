package com.yzy.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 权限表，与角色表是多对多的关系
 * @date 2023/5/19 14:31
 */
@Entity
@Table(name = "t_permission")
@Data
public class Permission {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限关键字
     */
    private String keyword;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 维护和角色表的多对多关系
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "t_permission_role",
            joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;
}
