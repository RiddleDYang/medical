package com.yzy.test;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.yzy.dao.RoleDao;
import com.yzy.dao.UserDao;
import com.yzy.domain.Role;
import com.yzy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Riddle
 * @version 1.0
 * @description 用户表和角色表的测试类
 * @date 2023/5/19 15:33
 */
@SpringBootTest
public class UserRoleTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 生成用户表、角色表和用户角色关系表并添加数据
     */
    @Test
    public void testSave() {
        User user1 = new User();
        user1.setBirthday(new Date());
        user1.setGender("男");
        user1.setUsername("admin");
        user1.setPassword("123456");


        User user2 = new User();
        user2.setBirthday(new Date());
        user2.setGender("男");
        user2.setUsername("zhangsan");
        user2.setPassword("123456");


        Role role1 = new Role();
        role1.setName("系统管理员");
        role1.setKeyword("ROLE_ADMIN");


        Role role2 = new Role();
        role2.setName("健康管理师");
        role2.setKeyword("ROLE_HEALTH_MANAGER");


        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);


        user1.setRoles(roles);
        user2.setRoles(roles);

        role1.setUsers(users);
        role2.setUsers(users);


        userDao.save(user1);
        userDao.save(user2);

        roleDao.save(role1);
        roleDao.save(role2);

    }
}
