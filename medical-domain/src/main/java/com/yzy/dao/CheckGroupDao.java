package com.yzy.dao;

import com.yzy.domain.CheckGroup;
import com.yzy.domain.CheckItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Riddle
 * @version 1.0
 * @date 2023/5/19 18:07
 */
public interface CheckGroupDao extends JpaRepository<CheckGroup, Integer>, JpaSpecificationExecutor<CheckGroup> {
}
