package com.ataguigu.system.test;

import com.atguigu.model.system.SysRole;
import com.ataguigu.system.mapper.SysRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SysRoleMappperTest {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<SysRole> users = sysRoleMapper.selectList(null);
        for (SysRole sysRole : users) {
            System.out.println("sysRole = " + sysRole);
        }
    }
//添加
    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int result = sysRoleMapper.insert(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole.getId()); //id自动回填
    }
//修改
    @Test
    public void testUpdateById(){
        SysRole sysRole=sysRoleMapper.selectById(1);
        sysRole.setDescription("系统管理员");
        int result = sysRoleMapper.updateById(sysRole);
        System.out.println(result);


    }
    //批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        //条件查询
//        queryWrapper.ge("role_code", "role");

        //模糊查询
        queryWrapper.like("role_name","用户管理员");
        List<SysRole> users = sysRoleMapper.selectList(queryWrapper);
        System.out.println(users);
    }
    @Test
    public void  TestDel(){
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("role_code", "用户管理员");
    }

}