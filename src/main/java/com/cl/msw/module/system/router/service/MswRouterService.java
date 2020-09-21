package com.cl.msw.module.system.router.service;

import com.cl.msw.module.system.router.pojo.dto.MswRouterDTO;
import com.cl.msw.module.system.router.pojo.vo.MswRouterVO;

import java.util.List;

/**
 * Msw-路由-Service
 *
 * @author chengliang
 * @date 2020/9/16 16:02
 */
public interface MswRouterService {

    /**
     * 获取路由树
     *
     * @return 路由树
     */
    List<MswRouterVO> routerTree();

    /**
     * 新增路由
     *
     * @param dto 路由信息
     * @return 保存后的路由信息
     */
    MswRouterVO routerAdd(MswRouterDTO dto);

}
