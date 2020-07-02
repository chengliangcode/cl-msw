package com.cl.msw.util.common;

import com.cl.msw.component.base.MswConstantEnum;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Msw-枚举操作-Util
 *
 * @author chengliang
 * @date 2020/7/2 12:03
 */
public class MswEnumUtil {

    /**
     * 通过值获取说明
     *
     * @param clazz 枚举class
     * @param value 值
     * @return 说明
     */
    public static String desc(Class<? extends Enum<? extends MswConstantEnum>> clazz, Integer value) {
        return MswEnumUtil.constantEnum(clazz, value).getDesc();
    }

    /**
     * 通过值获取枚举对象
     *
     * @param clazz 枚举class
     * @param value 值
     * @return 枚举对象
     */
    public static MswConstantEnum constantEnum(Class<? extends Enum<? extends MswConstantEnum>> clazz, Integer value) {

        if (value == null) {
            throw new RuntimeException("获取常量枚举的值必须不为空");
        }
        MswConstantEnum[] mswConstantEnums = MswEnumUtil.parseEnumClass(clazz);
        List<MswConstantEnum> collect = Arrays.stream(mswConstantEnums).parallel().filter(mswConstantEnum -> mswConstantEnum.getValue().equals(value)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect) || collect.size() != 1) {
            throw new RuntimeException("常量枚举不符合规则,获取失败");
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
    public static Boolean equal(MswConstantEnum mswConstantEnum, Integer value) {
        return mswConstantEnum.getValue().equals(value);
    }

    /**
     * 解析枚举class
     *
     * @param clazz 枚举class
     * @return Msw-基础-ConstantEnum
     */
    private static MswConstantEnum[] parseEnumClass(Class<? extends Enum<? extends MswConstantEnum>> clazz) {
        Enum<? extends MswConstantEnum>[] enumConstants = clazz.getEnumConstants();
        return (MswConstantEnum[]) enumConstants;
    }

}
