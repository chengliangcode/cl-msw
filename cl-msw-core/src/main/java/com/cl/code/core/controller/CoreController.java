package com.cl.code.core.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengliang
 * @date 2021/1/5 17:23
 */
@RestController
@RequestMapping("user")
public class CoreController {

    @PostMapping("/hello/{name}")
    @PreAuthorize("hasAuthority('p1')")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
