package com.cl.code.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * @author chengliang
 * @date 2021/1/5 15:13
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 授权服务令牌端点安全约束
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 客户端配置
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 内存方式
        clients.inMemory()
                // clientId 客户端id
                .withClient("gateway")
                .resourceIds("cl-msw-core")
                // secret 密钥
                .secret(new BCryptPasswordEncoder().encode("secret"))
                // 可访问的资源列表
                // 授权类型
                .authorizedGrantTypes("password")
                // 允许的授权范围
                .scopes("all");
//                // 是否跳转到授权页面
//                .autoApprove(false)
//                // 回调地址
//                .redirectUris("https://www.baidu.com");
    }

    /**
     * 授权服务令牌访问端点配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 密码模式需要
                .authenticationManager(authenticationManager)
                // 授权码模式需要
//                .authorizationCodeServices(authorizationCodeServices)
                // 令牌存储策略 -内存方式
                .tokenStore(new InMemoryTokenStore())
                .userDetailsService(userDetailsService)
                // 请求类型 -POST
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

}
