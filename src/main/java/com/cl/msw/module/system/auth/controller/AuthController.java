package com.cl.msw.module.system.auth.controller;

import com.cl.msw.component.base.Result;
import com.cl.msw.module.system.auth.pojo.dto.LoginDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengliang
 * @date 2020/7/29 17:40
 */
@RestController
@RequestMapping
public class AuthController {

    @PostMapping("/")
    public Result<Object> login(@RequestBody LoginDTO loginDTO) {
        return Result.success("123456");
    }

}
