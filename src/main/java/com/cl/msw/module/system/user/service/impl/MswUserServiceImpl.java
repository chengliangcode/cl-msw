package com.cl.msw.module.system.user.service.impl;

import com.cl.msw.component.constant.DeletedEnum;
import com.cl.msw.component.constant.EnableEnum;
import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.po.MswUser;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import com.cl.msw.module.system.user.service.MswUserService;
import com.cl.msw.util.common.CopyUtils;
import com.cl.msw.util.common.MswEnumUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * Msw-用户-ServiceImpl
 *
 * @author chengliang
 * @date 2020/7/2 10:26
 */
@Service
public class MswUserServiceImpl implements MswUserService {

    @Resource
    MswUserMapper mswUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MswUserDetailVO save(@NotNull MswUserDTO mswUserDTO) {
        MswUser mswUser = CopyUtils.copyObj(mswUserDTO, MswUser.class);
        mswUser.setDeleted(DeletedEnum.NOT_DELETE.getValue())
                .setCreateTime(System.currentTimeMillis())
                .setCreatePersonId(1L)
                .setUpdateTime(System.currentTimeMillis())
                .setUpdatePersonId(1L);
        mswUserMapper.insert(mswUser);
        MswUserDetailVO mswUserDetailVO = CopyUtils.copyObj(mswUser, MswUserDetailVO.class);
        mswUserDetailVO.setEnableName(MswEnumUtils.desc(EnableEnum.class, mswUserDetailVO.getEnable()));
        return mswUserDetailVO;
    }

}
