package com.cl.msw.module.system.role.pojo.po;

import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Msw-角色-实体类
 *
 * @author chengliang
 * @date 2020/8/3 11:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MswRole {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

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

    public static final String ROLE_NAME = "roleName";

    public static final String ENABLE_STATE = "enableState";

    public static final String DELETE_STATE = "deleteState";

    public static final String CREATE_TIME = "createTime";

    public static final String CREATE_PERSON_ID = "createPersonId";

    public static final String UPDATE_TIME = "updateTime";

    public static final String UPDATE_PERSON_ID = "updatePersonId";

}
