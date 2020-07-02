package com.cl.msw.module.system.user.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Msw-用户-DTO
 *
 * @author chengliang
 * @date 2020/7/2 10:28
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MswUserDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 启用状态 0-禁用 1-启用
     */
    private Integer enable;

}
