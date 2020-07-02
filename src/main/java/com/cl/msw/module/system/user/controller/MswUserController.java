package com.cl.msw.module.system.user.controller;

import com.cl.msw.component.base.Save;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.service.MswUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Msw-用户-Controller
 *
 * @author chengliang
 * @date 2020/7/2 10:26
 */
@Validated
@RestController
@RequestMapping("/system/user")
public class MswUserController {

    @Resource
    MswUserService mswUserService;

    /**
     * 保存操作
     *
     * @param mswUserDTO Msw-用户-DTO
     * @return Msw-用户-DetailVO
     */
    @PostMapping("/save")
    public Object save(@RequestBody @Validated(Save.class) MswUserDTO mswUserDTO) {
        return mswUserService.save(mswUserDTO);
    }

}
