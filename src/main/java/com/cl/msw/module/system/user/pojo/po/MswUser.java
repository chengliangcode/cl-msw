package com.cl.msw.module.system.user.pojo.po;

import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Msw-用户-实体类
 *
 * @author chengliang
 * @date 2020/9/29 14:52
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
    private String name;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机
     */
    private String telephone;

    /**
     * 启用状态 0-禁用 1-启用
     */
    private Integer enableState;

    /**
     * 删除状态 0-未删 1-已删
     */
    private Integer deleteState;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 创建人id
     */
    private Long createPersonId;

    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 最后更新人id
     */
    private Long updatePersonId;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String AVATAR = "avatar";

    public static final String TELEPHONE = "telephone";

    public static final String ENABLE_STATE = "enableState";

    public static final String DELETE_STATE = "deleteState";

    public static final String CREATE_TIME = "createTime";

    public static final String CREATE_PERSON_ID = "createPersonId";

    public static final String UPDATE_TIME = "updateTime";

    public static final String UPDATE_PERSON_ID = "updatePersonId";

}
