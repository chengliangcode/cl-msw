package com.cl.msw.module.system.user.controller;

import com.cl.msw.module.system.user.service.MswUserService;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("")
public class MswUserController {

    @Resource
    MswUserService mswUserService;

}
