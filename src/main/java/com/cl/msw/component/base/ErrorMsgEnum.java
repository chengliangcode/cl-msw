package com.cl.msw.component.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Common-异常信息-Enum
 *
 * @author chengliang
 * @date 2020/7/2 17:03
 */
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {
    // 500-操作失败 403-无权限访问
    FAIL(500, "操作失败"),

    ACCESS_DENIED(403, "无权限访问");

    private final Integer code;

    private final String desc;

}
