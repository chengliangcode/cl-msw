package com.cl.msw.module.system.user.service.impl;

import com.cl.msw.component.constant.system.DeleteStateEnum;
import com.cl.msw.component.constant.system.EnableStateEnum;
import com.cl.msw.module.system.user.mapper.MswUserMapper;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.po.MswUser;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import com.cl.msw.module.system.user.service.MswUserService;
import com.cl.msw.util.common.CopyUtils;
import com.cl.msw.util.common.MswEnumUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

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
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        mswUser
                .setPassword(bCryptPasswordEncoder.encode(mswUser.getPassword()))
                .setDeleteState(DeleteStateEnum.NOT_DELETE.getValue())
                .setCreateTime(System.currentTimeMillis())
                .setCreatePersonId(1L)
                .setUpdateTime(System.currentTimeMillis())
                .setUpdatePersonId(1L);
        mswUserMapper.insert(mswUser);
        MswUserDetailVO mswUserDetailVO = CopyUtils.copyObj(mswUser, MswUserDetailVO.class);
        mswUserDetailVO.setEnableName(MswEnumUtils.desc(EnableStateEnum.class, mswUserDetailVO.getEnableState()));
        return mswUserDetailVO;
    }

    @Override
    public User authUser(String login) {
        Example example = new Example(MswUser.class);
        example.createCriteria().andEqualTo(MswUser.ACCOUNT, login);
        List<MswUser> mswUsers = mswUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(mswUsers) || mswUsers.size() > 1) {
            return null;
        } else {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            List<GrantedAuthority> grantedAuthorities = Collections.singletonList(grantedAuthority);
            MswUser mswUser = mswUsers.get(0);
            return new User(mswUser.getUsername(), mswUser.getPassword(), mswUser.getEnableState().equals(EnableStateEnum.ENABLE.getValue()), true, true, true, grantedAuthorities);
        }
    }
}
