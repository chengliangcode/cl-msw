package com.cl.msw.module.system.router.controller;

import com.cl.msw.component.base.Result;
import com.cl.msw.component.base.Save;
import com.cl.msw.module.system.router.pojo.dto.MswRouterDTO;
import com.cl.msw.module.system.router.pojo.vo.MswRouterVO;
import com.cl.msw.module.system.router.service.MswRouterService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Msw-路由-Controller
 *
 * @author chengliang
 * @date 2020/9/16 16:02
 */
@Validated
@RestController
@RequestMapping("/router")
public class MswRouterController {

    @Resource
    MswRouterService mswRouterService;

    /**
     * 获取路由树
     *
     * @return 路由树
     */
    @PostMapping("/tree")
    Result<List<MswRouterVO>> routerTree() {
        return Result.success(mswRouterService.routerTree());
    }

    /**
     * 新增路由
     *
     * @param dto 路由信息
     * @return 保存后的路由信息
     */
    @PostMapping("/add")
    Result<MswRouterVO> routerAdd(@RequestBody @Validated(Save.class) MswRouterDTO dto) {
        return Result.success(mswRouterService.routerAdd(dto));
    }

    /**
     * 删除路由
     *
     * @param ids id集合
     * @return void
     */
    @DeleteMapping("/{ids}")
    Result<Object> routerDelete(@PathVariable("ids") List<Long> ids) {
        mswRouterService.routerDelete(ids);
        return Result.success();
    }

}
