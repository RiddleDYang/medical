package com.yzy.test;
import java.util.Date;

import com.yzy.dao.OrderSettingDao;
import com.yzy.domain.OrderSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Riddle
 * @version 1.0
 * @description 预约排期表测试类
 * @date 2023/5/19 22:17
 */
@SpringBootTest
public class OrderSettingTest {

    @Autowired
    private OrderSettingDao orderSettingDao;

    /**
     * 生成预约排期表并保存数据
     */
    @Test
    public void testSave() {
        OrderSetting orderSetting = new OrderSetting();
        orderSetting.setOrderDate(new Date());
        orderSetting.setNumber(10);
        orderSetting.setReservations(3);

        orderSettingDao.save(orderSetting);
    }
}
