package com.cl.code.security.auth;

import jdk.nashorn.internal.parser.Token;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chengliang
 * @date 2021/1/8 16:59
 */
@RestController
@RequestMapping("oauth")
public class AuthController {

    @Resource
    AuthorizationServerTokenServices authorizationServerTokenServices;


    @GetMapping("/user/info")
    public Object userInfo(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        System.out.println(token);
//        authorizationServerTokenServices.
        return null;
    }
}
