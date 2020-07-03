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
public enum ResultSuccessMsgEnum {
    // 200-操作成功
    SUCCESS(200, "操作成功");

    private final Integer code;

    private final String desc;

}
