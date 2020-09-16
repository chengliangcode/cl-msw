package com.cl.msw.module.system.role.controller;

import com.cl.msw.module.system.role.service.MswRoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Msw-角色-Controller
 *
 * @author chengliang
 * @date 2020/8/3 11:45
 */
@Validated
@RestController
@RequestMapping("/system/role")
public class MswRoleController {

    @Resource
    MswRoleService mswRoleService;

}
