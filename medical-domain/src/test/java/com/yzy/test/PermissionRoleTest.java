package com.yzy.test;

import com.yzy.dao.PermissionDao;
import com.yzy.dao.RoleDao;
import com.yzy.dao.UserDao;
import com.yzy.domain.Permission;
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
 * @description 用户表和权限表的测试类
 * @date 2023/5/19 15:33
 */
@SpringBootTest
public class PermissionRoleTest {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 生成用户表、权限表和权限角色关系表并添加数据
     */
    @Test
    public void testSave() {
        Permission permission1 = new Permission();
        permission1.setName("新增检查项");
        permission1.setKeyword("CHECKITEM_ADD");

        Permission permission2 = new Permission();
        permission2.setName("删除检查项");
        permission2.setKeyword("CHECKITEM_DELETE");


        Role role = new Role();
        role.setName("系统管理员");
        role.setKeyword("ROLE_ADMIN");


        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission1);
        permissions.add(permission2);

        List<Role> roles = new ArrayList<>();
        roles.add(role);


        permission1.setRoles(roles);
        permission2.setRoles(roles);

        role.setPermissions(permissions);

        permissionDao.save(permission1);
        permissionDao.save(permission2);

        roleDao.save(role);
    }
}
