package com.cl.msw.module.system.role.service.impl;

import com.cl.msw.module.system.role.mapper.MswRoleMapper;
import com.cl.msw.module.system.role.service.MswRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Msw-角色-ServiceImpl
 *
 * @author chengliang
 * @date 2020/8/3 11:45
 */
@Service
public class MswRoleServiceImpl implements MswRoleService {

    @Resource
    MswRoleMapper mswRoleMapper;

}
