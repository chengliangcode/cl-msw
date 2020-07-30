package com.cl.msw.util.common;

import com.cl.msw.component.base.MswConstantEnum;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Msw-枚举操作-Utils
 *
 * @author chengliang
 * @date 2020/7/2 12:03
 */
public class MswEnumUtils {

    /**
     * 通过值获取枚举说明
     *
     * @param clazz 枚举class
     * @param value 值
     * @return 枚举说明
     */
    public static <T> String desc(Class<? extends Enum<? extends MswConstantEnum<T>>> clazz, T value) {
        return MswEnumUtils.constantEnum(clazz, value).getDesc();
    }

    /**
     * 通过值获取枚举对象
     *
     * @param clazz 枚举class
     * @param value 值
     * @return 枚举对象
     */
    public static <T> MswConstantEnum<T> constantEnum(Class<? extends Enum<? extends MswConstantEnum<T>>> clazz, T value) {

        if (value == null) {
            throw new RuntimeException(String.format("获取常量枚举{%s}的值必须不为空", clazz.getName()));
        }
        MswConstantEnum<T>[] mswConstantEnums = MswEnumUtils.parseEnumClass(clazz);
        if (mswConstantEnums.length == 0) {
            throw new RuntimeException(String.format("常量枚举{%s}不存在实例", clazz.getName()));
        }
        List<MswConstantEnum<T>> collect = Arrays.stream(mswConstantEnums).parallel().filter(mswConstantEnum -> mswConstantEnum.getValue().equals(value)).collect(Collectors.toList());
        if (collect.size() != 1) {
            throw new RuntimeException(String.format("常量枚举{%s}有多个相同的value,不符合规则", clazz.getName()));
        } else if (CollectionUtils.isEmpty(collect)) {
            throw new RuntimeException(String.format("{%s}不存在于常量枚举{%s}里,获取失败", value, clazz.getName()));
        }
        return collect.get(0);
    }

    /**
     * 对比枚举类型与值是否相符
     *
     * @param mswConstantEnum Msw-基础-ConstantEnum
     * @param value           值
     * @return boolean
     */
    public static <T> Boolean equal(MswConstantEnum<T> mswConstantEnum, T value) {
        return mswConstantEnum.getValue().equals(value);
    }

    /**
     * 解析枚举class
     *
     * @param clazz 枚举class
     * @return Msw-基础-ConstantEnum
     */
    private static <T> MswConstantEnum<T>[] parseEnumClass(Class<? extends Enum<? extends MswConstantEnum<T>>> clazz) {
        Enum<? extends MswConstantEnum<T>>[] enumConstants = clazz.getEnumConstants();
        return (MswConstantEnum<T>[]) enumConstants;
    }

}
