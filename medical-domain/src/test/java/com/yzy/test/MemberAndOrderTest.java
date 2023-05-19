package com.yzy.test;

import com.yzy.dao.MemberDao;
import com.yzy.dao.OrderDao;
import com.yzy.dao.SetMealDao;
import com.yzy.domain.Member;
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
 * @description 会员表、订单表的测试类
 * @date 2023/5/19 20:10
 */
@SpringBootTest
public class MemberAndOrderTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SetMealDao setMealDao;

    /**
     * 生成会员表，订单表.
     * 订单表外键 set_meal_id 指向套餐表主键，并添加数据
     * 订单表外键 member_id 指向会员表主键，并添加数据
     */
    @Test
    public void testSave() {

        //会员信息
        Member member = new Member();
        member.setName("黄圣豪");
        member.setGender('1');
        member.setIdCard("999888");
        member.setPassword("123456");
        member.setPhoneNumber("18888887777");
        member.setRegTime(new Date());
        member.setEmail("huangshenghao@163.com");
        member.setBirthday(new Date());

        //订单信息
        Order order = new Order();
        order.setOrderDate(new Date());
        order.setOrderType("微信预约");
        order.setOrderStatus("未到诊");

        Order order1 = new Order();
        order1.setOrderDate(new Date());
        order1.setOrderType("电话预约");
        order1.setOrderStatus("未到诊");

        //套餐信息
        SetMeal setMeal = new SetMeal();
        setMeal.setName("帅男团");
        setMeal.setCode("0001");
        setMeal.setHelpCode("SNT");
        setMeal.setGender('1');
        setMeal.setAge("0-100");
        setMeal.setPrice(3000F);
        setMeal.setRemark("关心男性健康");
        setMeal.setImg("54275965-057c-4fe2-af33-33dea3b79cef.jpg");

        //会员信息关联订单信息
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);

        member.setOrders(orders);

        //订单信息关联会员信息
        order.setMemberId(member);
        order1.setMemberId(member);

        //套餐信息关联订单信息
        setMeal.setOrders(orders);

        //订单信息关联套餐信息
        order.setSetMealId(setMeal);
        order1.setSetMealId(setMeal);

        memberDao.save(member);

        orderDao.save(order);
        orderDao.save(order1);

        setMealDao.save(setMeal);

    }
}
