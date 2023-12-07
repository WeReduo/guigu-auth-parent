package com.ataguigu.system.controller;

import com.ataguigu.system.service.SysRoleService;
import com.atguigu.model.system.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("角色管理的接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    //http://localhost:8800/admin/system/sysRole/findAll
    //查询所有记录
    @ApiOperation("查询所有记录的接口")
    @GetMapping("/findAll")
    public List<SysRole> findAll() {
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }
    //逻辑删除
    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("/remove/{id}")
    public  boolean removeRole(@PathVariable long id){
        //调用方法进行删除
        boolean isSucess=sysRoleService.removeById(id);

        return isSucess;

    }

}
