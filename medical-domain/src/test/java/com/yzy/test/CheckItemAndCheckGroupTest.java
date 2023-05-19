package com.yzy.test;
import com.yzy.domain.CheckGroup;

import com.yzy.dao.CheckGroupDao;
import com.yzy.dao.CheckItemDao;
import com.yzy.dao.MenuDao;
import com.yzy.dao.RoleDao;
import com.yzy.domain.CheckItem;
import com.yzy.domain.Menu;
import com.yzy.domain.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 检查项目表和检查项目组表的测试类
 * @date 2023/5/19 15:33
 */
@SpringBootTest
public class CheckItemAndCheckGroupTest {

    @Autowired
    private CheckItemDao checkItemDao;

    @Autowired
    private CheckGroupDao checkGroupDao;

    /**
     * 生成检查项目表和检查项目组表，以及维护关系的中间表，并添加数据
     */
    @Test
    public void testSave() {

        CheckItem checkItem = new CheckItem();
        checkItem.setCode("0001");
        checkItem.setName("身高");
        checkItem.setGender('0');
        checkItem.setAge("0-100");
        checkItem.setPrice(5F);
        checkItem.setType('1');
        checkItem.setRemark("身高");


        CheckItem checkItem1 = new CheckItem();
        checkItem1.setCode("0002");
        checkItem1.setName("体重");
        checkItem1.setGender('0');
        checkItem1.setAge("0-100");
        checkItem1.setPrice(5F);
        checkItem1.setType('1');
        checkItem1.setRemark("体重");

        CheckGroup checkGroup = new CheckGroup();
        checkGroup.setCode("001");
        checkGroup.setName("一般检查");
        checkGroup.setHelpCode("YBJC");
        checkGroup.setGender('0');
        checkGroup.setRemark("一般检查");

        List<CheckItem> checkItems = new ArrayList<>();
        checkItems.add(checkItem);
        checkItems.add(checkItem1);

        List<CheckGroup> checkGroups = new ArrayList<>();
        checkGroups.add(checkGroup);

        checkItem.setCheckGroups(checkGroups);
        checkGroup.setCheckItems(checkItems);


        checkItemDao.save(checkItem);
        checkItemDao.save(checkItem1);

        checkGroupDao.save(checkGroup);
    }
}
