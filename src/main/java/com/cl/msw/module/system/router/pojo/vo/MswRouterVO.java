package com.cl.msw.module.system.router.pojo.vo;

import com.cl.msw.component.base.TreeData;
import lombok.Data;

import java.util.List;

/**
 * Msw-路由-VO
 *
 * @author chengliang
 * @date 2020/9/16 16:03
 */
@Data
public class MswRouterVO implements TreeData<MswRouterVO> {

    /**
     * id
     */
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

    /**
     * 子路由集合
     */
    private List<MswRouterVO> children;

}
