package com.cl.msw.util.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author chengliang
 * @date 2020/7/15 14:45
 */
@Slf4j
public class MswRunListener implements SpringApplicationRunListener {

    MswRunListener(SpringApplication application, String[] arg) {
        log.info("Msw启动监听器初始化成功");
    }

    @Override
    public void starting() {
        log.info("Msw项目正在启动...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("Msw环境准备完毕");
        log.info(environment.toString());
    }

}
