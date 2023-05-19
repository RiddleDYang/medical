package com.yzy.dao;

import com.yzy.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Riddle
 * @version 1.0
 * @date 2023/5/19 15:35
 */
public interface RoleDao extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
}
