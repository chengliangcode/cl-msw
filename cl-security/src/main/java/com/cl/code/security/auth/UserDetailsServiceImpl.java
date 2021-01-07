package com.cl.code.security.auth;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chengliang
 * @date 2021/1/5 16:49
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return User.builder()
                .username("cl")
                .password(passwordEncoder.encode("123456"))
                .roles("USER")
                .authorities("p1")
                .build();
    }

}
