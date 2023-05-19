package com.yzy.dao;

import com.yzy.domain.OrderSetting;
import com.yzy.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Riddle
 * @version 1.0
 * @description TODO
 * @date 2023/5/19 22:18
 */
public interface OrderSettingDao extends JpaRepository<OrderSetting, Integer>, JpaSpecificationExecutor<OrderSetting> {
}
