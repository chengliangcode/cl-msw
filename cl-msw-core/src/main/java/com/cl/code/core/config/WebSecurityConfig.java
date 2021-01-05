package com.cl.code.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chengliang
 * @date 2021/1/5 17:49
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(auth ->
                        auth
                                .antMatchers("/**").hasAuthority("SCOPE_all")
                                .antMatchers("/core/**").hasAuthority("p3")
                                .anyRequest().authenticated()

                );
    }

}
