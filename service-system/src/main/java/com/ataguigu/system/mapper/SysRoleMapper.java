package com.ataguigu.system.mapper;

import com.ataguigu.model.system.SysRole;
import com.ataguigu.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> page, @Param("vo") SysRoleQueryVo roleQueryVo);



}