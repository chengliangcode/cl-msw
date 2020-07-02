package com.cl.msw.module.system.user.service.impl;

import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.service.MswUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Msw用户-ServiceImpl
 *
 * @author chengliang
 * @date 2020/7/2 10:26
 */
@Service
public class MswUserServiceImpl implements MswUserService {

    @Resource
    MswUserMapper mswUserMapper;

}
