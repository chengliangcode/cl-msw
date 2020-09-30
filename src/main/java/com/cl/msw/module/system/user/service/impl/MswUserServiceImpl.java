package com.cl.msw.module.system.user.service.impl;

import com.cl.msw.component.auth.LoginUserVO;
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
    private MswUserMapper mswUserMapper;

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

    private MswUser getUser(String username) {
        Example example = new Example(MswUser.class);
        example.createCriteria().andEqualTo(MswUser.USERNAME, username);
        List<MswUser> mswUsers = mswUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(mswUsers)) {
            throw new RuntimeException("找不到用户名为" + username + "的用户");
        } else if (mswUsers.size() > 1) {
            throw new RuntimeException(username + "用户名对应多个用户，不符合用户名唯一性");
        } else {
            return mswUsers.get(0);
        }
    }

    @Override
    public User authUser(String login) {
        MswUser mswUser = this.getUser(login);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        List<GrantedAuthority> grantedAuthorities = Collections.singletonList(grantedAuthority);
        return new User(mswUser.getUsername(), mswUser.getPassword(), mswUser.getEnableState().equals(EnableStateEnum.ENABLE.getValue()), true, true, true, grantedAuthorities);

    }

    @Override
    public LoginUserVO userInfo(String username) {
        MswUser mswUser = this.getUser(username);

        return LoginUserVO.builder()
                .id(mswUser.getId())
                .name(mswUser.getName())
                .username(mswUser.getUsername())
                .avatar(mswUser.getAvatar())
                .telephone(mswUser.getTelephone())
                .build();
    }

}
