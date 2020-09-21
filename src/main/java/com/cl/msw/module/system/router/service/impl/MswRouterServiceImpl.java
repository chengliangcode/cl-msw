package com.cl.msw.module.system.router.service.impl;

import com.cl.msw.module.system.router.mapper.MswRouterMapper;
import com.cl.msw.module.system.router.pojo.dto.MswRouterDTO;
import com.cl.msw.module.system.router.pojo.po.MswRouter;
import com.cl.msw.module.system.router.pojo.vo.MswRouterVO;
import com.cl.msw.module.system.router.service.MswRouterService;
import com.cl.msw.util.common.CopyUtils;
import com.cl.msw.util.common.TreeUtil;
import com.cl.msw.util.common.TwiterIdUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Msw-路由-ServiceImpl
 *
 * @author chengliang
 * @date 2020/9/16 16:02
 */
@Service
public class MswRouterServiceImpl implements MswRouterService {

    @Resource
    MswRouterMapper mswRouterMapper;

    @Override
    public List<MswRouterVO> routerTree() {
        List<MswRouter> mswRouters = mswRouterMapper.selectAll();
        List<MswRouterVO> mswRouterVOS = CopyUtils.copyList(mswRouters, MswRouterVO.class);
        return TreeUtil.toTree(mswRouterVOS);
    }

    @Override
    public MswRouterVO routerAdd(MswRouterDTO dto) {
        MswRouter po = CopyUtils.copyObj(dto, MswRouter.class);
        po.setId(TwiterIdUtil.getTwiterId());
        mswRouterMapper.insert(po);
        return CopyUtils.copyObj(po, MswRouterVO.class);
    }

}
