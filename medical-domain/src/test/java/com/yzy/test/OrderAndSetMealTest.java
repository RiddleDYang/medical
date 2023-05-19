package com.yzy.test;

import com.yzy.dao.OrderDao;
import com.yzy.dao.SetMealDao;
import com.yzy.domain.Order;
import com.yzy.domain.SetMeal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description TODO
 * @date 2023/5/19 20:10
 */
@SpringBootTest
public class OrderAndSetMealTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SetMealDao setMealDao;

    /**
     * 生成订单表，订单表外键指向套餐表主键，并添加数据
     */
    @Test
    public void testSave() {

        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderType("微信预约");
        order.setOrderStatus("未到诊");

        Order order1 = new Order();
        order1.setOrderDate(new Date());
        order1.setOrderType("电话预约");
        order1.setOrderStatus("已到诊");

        SetMeal setMeal = new SetMeal();
        setMeal.setName("帅男团");
        setMeal.setCode("0001");
        setMeal.setHelpCode("SNT");
        setMeal.setGender('1');
        setMeal.setAge("0-100");
        setMeal.setPrice(3000F);
        setMeal.setRemark("关心男性健康");
        setMeal.setImg("54275965-057c-4fe2-af33-33dea3b79cef.jpg");


        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);

        order.setSetMealId(setMeal);
        order1.setSetMealId(setMeal);
        setMeal.setOrders(orders);

        orderDao.save(order);
        orderDao.save(order1);
        setMealDao.save(setMeal);

    }
}
