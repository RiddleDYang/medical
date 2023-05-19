package com.yzy.dao;

import com.yzy.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Riddle
 * @version 1.0
 * @date 2023/5/19 16:44
 */
public interface PermissionDao extends JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {
}
