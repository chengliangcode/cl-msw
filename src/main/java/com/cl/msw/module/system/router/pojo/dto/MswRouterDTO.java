package com.cl.msw.module.system.router.pojo.dto;

import com.cl.msw.component.base.Save;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Msw-路由-DTO
 *
 * @author chengliang
 * @date 2020/9/16 16:22
 */
@Data
public class MswRouterDTO {

    /**
     * 路由名称
     */
    @NotBlank(groups = Save.class, message = "路由名称不能为空")
    private String routerName;

    /**
     * 路由路径
     */
    @NotBlank(groups = Save.class, message = "路由路径不能为空")
    private String routerPath;

    /**
     * 路由别名
     */
    private String routerAlias;

    /**
     * 父级路由id
     */
    private Long parentId;

}
