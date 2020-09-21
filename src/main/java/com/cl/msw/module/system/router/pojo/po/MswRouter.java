package com.cl.msw.module.system.router.pojo.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;

/**
 * Msw-路由-实体类
 *
 * @author chengliang
 * @date 2020/9/16 16:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MswRouter {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 路由名称
     */
    private String routerName;

    /**
     * 路由路径
     */
    private String routerPath;

    /**
     * 路由别名
     */
    private String routerAlias;

    /**
     * 父级路由id
     */
    private Long parentId;

    public static final String ID = "id";

    public static final String ROUTER_NAME = "routerName";

    public static final String ROUTER_PATH = "routerPath";

    public static final String ROUTER_ALIAS = "routerAlias";

    public static final String PARENT_ID = "parentId";


}
