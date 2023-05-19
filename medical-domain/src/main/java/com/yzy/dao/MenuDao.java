package com.yzy.dao;

import com.yzy.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Riddle
 * @version 1.0
 * @date 2023/5/19 17:02
 */
public interface MenuDao extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu> {
}
