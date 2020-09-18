package com.cl.msw.module.system.auth.controller;

import com.cl.msw.component.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author chengliang
 * @date 2020/7/29 17:40
 */
@RestController
@RequestMapping
public class AuthController {

    @Resource
    RequestMappingHandlerMapping mapping;

    @GetMapping({"/", "/one"})
    public Result<Object> login(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        System.out.println(Arrays.toString(cookies));
        response.addCookie(new Cookie("1111", "11111"));
        return Result.success("123456");
    }

    @PostMapping("/auth")
    public Result<Object> auth() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            Set<String> patterns = requestMappingInfo.getPatternsCondition().getPatterns();
            String name = handlerMethod.getMethod().getName();
            System.out.println(patterns + "-" + name);
        });
        return Result.success();
    }
}
