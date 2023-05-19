package com.yzy.test;

import com.yzy.dao.CheckGroupDao;
import com.yzy.dao.CheckItemDao;
import com.yzy.dao.SetMealDao;
import com.yzy.domain.CheckGroup;
import com.yzy.domain.CheckItem;
import com.yzy.domain.SetMeal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 套餐表和检查项目组表的测试类
 * @date 2023/5/19 15:33
 */
@SpringBootTest
public class SetMealAndCheckGroupTest {

    @Autowired
    private SetMealDao setMealDao;

    @Autowired
    private CheckGroupDao checkGroupDao;

    /**
     * 生成检查项目表和检查项目组表，以及维护关系的中间表，并添加数据
     */
    @Test
    public void testSave() {

        CheckGroup checkGroup = new CheckGroup();
        checkGroup.setCode("001");
        checkGroup.setName("一般检查");
        checkGroup.setHelpCode("YBJC");
        checkGroup.setGender('0');
        checkGroup.setRemark("一般检查");

        List<CheckGroup> checkGroups = new ArrayList<>();
        checkGroups.add(checkGroup);


        SetMeal setMeal = new SetMeal();
        setMeal.setName("帅男团");
        setMeal.setCode("0001");
        setMeal.setHelpCode("SNT");
        setMeal.setGender('1');
        setMeal.setAge("0-100");
        setMeal.setPrice(3000F);
        setMeal.setRemark("关心男性健康");
        setMeal.setImg("54275965-057c-4fe2-af33-33dea3b79cef.jpg");

        List<SetMeal> setMeals = new ArrayList<>();
        setMeals.add(setMeal);


        checkGroup.setSetMeals(setMeals);
        setMeal.setCheckGroups(checkGroups);



        setMealDao.save(setMeal);

        checkGroupDao.save(checkGroup);
    }
}
