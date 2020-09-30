package com.cl.msw.component.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户VO
 *
 * @author chengliang
 * @date 2020/9/29 16:03
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVO {

    private Long id;

    private String name;

    private String username;

    private String avatar;

    private String telephone;

}
