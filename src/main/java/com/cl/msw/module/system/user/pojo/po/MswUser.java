package com.cl.msw.module.system.user.pojo.po;

import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Msw-用户-实体类
 *
 * @author chengliang
 * @date 2020/7/2 10:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MswUser {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
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

    /**
     * 删除状态 0-未删 1-已删
     */
    private Integer deleted;

    public static final String ID = "id";

    public static final String USERNAME = "username";

    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";

    public static final String PHONE = "phone";

    public static final String EMAIL = "email";

    public static final String ENABLE = "enable";

    public static final String DELETED = "deleted";

}
