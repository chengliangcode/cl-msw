package com.cl.msw.module.system.user.service;

import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;

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
    MswUserDetailVO save(MswUserDTO mswUserDTO);

}
