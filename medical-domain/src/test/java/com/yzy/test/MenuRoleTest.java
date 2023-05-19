package com.yzy.test;

import com.yzy.dao.MenuDao;
import com.yzy.dao.RoleDao;
import com.yzy.dao.UserDao;
import com.yzy.domain.Menu;
import com.yzy.domain.Role;
import com.yzy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Riddle
 * @version 1.0
 * @description 用户表和菜单表的测试类
 * @date 2023/5/19 15:33
 */
@SpringBootTest
public class MenuRoleTest {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 生成用户表、菜单表和菜单角色关系表并添加数据
     */
    @Test
    public void testSave() {
        Menu menu = new Menu();
        menu.setName("会员管理");
        menu.setPath("2");
        menu.setPriority("1");
        menu.setIcon("fa-user-md");
        menu.setLevel("1");


        Menu menu1 = new Menu();
        menu1.setName("会员档案");
        menu.setLinkUrl("member.html");
        menu1.setPath("/2-1");
        menu1.setPriority("1");
        menu1.setParentMenuId(menu);
        menu1.setLevel("2");

        List<Menu> menus = new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);


        Role role1 = new Role();
        role1.setName("系统管理员");
        role1.setKeyword("ROLE_ADMIN");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);


        menu.setRoles(roles);
        menu1.setRoles(roles);

        role1.setMenus(menus);


        menuDao.save(menu);
        menuDao.save(menu1);

        roleDao.save(role1);

    }
}
