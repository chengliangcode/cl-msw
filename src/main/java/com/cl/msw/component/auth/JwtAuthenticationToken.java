package com.cl.msw.component.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * Common-JwtToken
 *
 * @author chengliang
 * @date 2020/7/14 10:42
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final Object credentials;


    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
    }


    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

}
