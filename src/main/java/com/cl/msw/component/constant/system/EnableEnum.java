package com.cl.msw.component.constant.system;

import com.cl.msw.component.base.MswConstantEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Msw-启用状态枚举-ConstantEnum
 *
 * @author chengliang
 * @date 2020/7/2 10:41
 */
@Getter
@AllArgsConstructor
public enum EnableEnum implements MswConstantEnum<Integer> {
    // 0-停用 1-启用
    DISABLE(0, "停用"),

    ENABLE(1, "启用");

    private final Integer value;

    private final String desc;

}
