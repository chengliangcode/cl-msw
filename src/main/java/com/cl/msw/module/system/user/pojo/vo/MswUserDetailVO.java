package com.cl.msw.module.system.user.pojo.vo;

import com.cl.msw.component.base.MswBaseVO;
import lombok.*;

/**
 * Msw-用户-DetailVO
 *
 * @author chengliang
 * @date 2020/7/2 10:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MswUserDetailVO extends MswBaseVO {

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
    private Integer enableState;

    /**
     * 启用状态名称 0-禁用 1-启用
     */
    private String enableName;

}
