package com.cl.msw.module.system.user.service;

import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import org.springframework.security.core.userdetails.User;

import javax.validation.constraints.NotNull;

/**
 * Msw-用户-Service
 *
 * @author chengliang
 * @date 2020/7/2 10:26
 */
public interface MswUserService {

    /**
     * 保存操作
     *
     * @param mswUserDTO Msw-用户-DTO
     * @return Msw-用户-DetailVO
     */
    MswUserDetailVO save(@NotNull MswUserDTO mswUserDTO);

    /**
     * 通过登录信息获取登录用户
     *
     * @param login 登录信息（账号，手机，邮箱等）
     * @return Security-user
     */
    User authUser(String login);

}
