package com.ataguigu.system.service.impl;

import com.ataguigu.system.mapper.SysRoleMapper;
import com.ataguigu.system.service.SysRoleService;
import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
