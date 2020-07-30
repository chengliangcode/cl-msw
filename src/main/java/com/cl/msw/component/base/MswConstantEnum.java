package com.cl.msw.component.base;

/**
 * Msw-基础-ConstantEnum
 *
 * @author chengliang
 * @date 2020/7/2 10:47
 */
public interface MswConstantEnum<T> {

    /**
     * 获取枚举值
     *
     * @return 值
     */
    T getValue();

    /**
     * 获取说明
     *
     * @return 说明
     */
    String getDesc();

}
