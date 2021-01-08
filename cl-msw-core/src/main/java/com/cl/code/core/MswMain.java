package com.cl.code.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author chengliang
 * @date 2021/1/5 14:54
 */
@SpringBootApplication
@EnableResourceServer
public class MswMain {

    public static void main(String[] args) {
        SpringApplication.run(MswMain.class, args);
    }

}
