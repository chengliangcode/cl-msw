package com.cl.code.security.auth;

import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author chengliang
 * @date 2021/1/8 16:59
 */
@RestController
@RequestMapping("oauth")
public class AuthController {

    @Resource
    TokenService tokenService;

    @GetMapping("/user/info")
    public Object userInfo(HttpServletRequest httpServletRequest) {
        Token authorization = tokenService.verifyToken(httpServletRequest.getHeader("Authorization"));
        return null;
    }
}
