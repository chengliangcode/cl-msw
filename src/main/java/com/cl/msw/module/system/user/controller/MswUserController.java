package com.cl.msw.module.system.user.controller;

import com.cl.msw.component.base.Result;
import com.cl.msw.component.base.Save;
import com.cl.msw.module.system.user.pojo.dto.MswUserDTO;
import com.cl.msw.module.system.user.pojo.vo.MswUserDetailVO;
import com.cl.msw.module.system.user.service.MswUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private MswUserService mswUserService;

    /**
     * 保存操作
     *
     * @param mswUserDTO Msw-用户-DTO
     * @return Msw-用户-DetailVO
     */
    @PostMapping("/save")
    public Result<MswUserDetailVO> save(@RequestBody @Validated(Save.class) MswUserDTO mswUserDTO) {
        return Result.success(mswUserService.save(mswUserDTO));
    }

    @GetMapping("/admin/info")
    public Result<String> admin() {
        return Result.success("admin 页面");
    }

    @GetMapping("/user/info")
    public Result<String> user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentUser = "";
        if (principal instanceof UserDetails) {
            currentUser = ((UserDetails) principal).getUsername();
        }
        return Result.success(String.format("user 页面，当前用户{%s}", currentUser));
    }

}
