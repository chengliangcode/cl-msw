package com.cl.msw.component.constant;

import com.cl.msw.component.base.MswConstantEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chengliang
 * @date 2020/7/2 12:46
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum implements MswConstantEnum {
    // 0-未删 1-已删
    NOT_DELETE(0, "未删"),

    DELETED(1, "已删");

    private final Integer value;

    private final String desc;

}