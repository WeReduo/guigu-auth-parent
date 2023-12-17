package com.ataguigu.system.controller;

import com.ataguigu.common.result.Result;
import com.ataguigu.system.config.exception.GuiguException;
import com.ataguigu.system.service.SysRoleService;
import com.ataguigu.model.system.SysRole;
import com.ataguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    public Result findAll() {
//        try {
//            int a = 10/0;
//        }catch(Exception e) {
//            throw new GuiguException(20001,"出现自定义异常");
//        }
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }

    //逻辑删除
    @ApiOperation("逻辑删除的接口")
    @DeleteMapping("/remove/{id}")
    public Result removeRole(@PathVariable long id) {
        //调用方法进行删除
        boolean isSucess = sysRoleService.removeById(id);
        if (isSucess) {
            return Result.ok();
        } else {
            return Result.fail();
        }


    }

    @ApiOperation(value = "获取分页列表")
    @GetMapping("/{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
                    SysRoleQueryVo roleQueryVo) {
        Page<SysRole> pageParam = new Page<>(page, limit);
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, roleQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取角色")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }
    @ApiOperation(value = "根据id查询")
    @PostMapping("/findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }
    @ApiOperation(value = "新增角色")
    @PostMapping("/save")
    public Result save(@RequestBody SysRole role) {
        sysRoleService.save(role);
        return Result.ok();
    }


    @ApiOperation(value = "修改角色")
    @PutMapping("/update")
    public Result updateById(@RequestBody SysRole role) {
        boolean isSucess = sysRoleService.removeById(role);
        if (isSucess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        sysRoleService.removeByIds(idList);
        return Result.ok();
    }
}