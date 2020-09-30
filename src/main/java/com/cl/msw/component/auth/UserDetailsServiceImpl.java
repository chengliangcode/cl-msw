package com.cl.msw.component.auth;

import com.cl.msw.module.system.user.service.MswUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chengliang
 * @date 2020/7/8 15:48
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private MswUserService mswUserService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = mswUserService.authUser(login);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }


}
