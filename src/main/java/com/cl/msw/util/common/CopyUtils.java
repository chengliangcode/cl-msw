package com.cl.msw.util.common;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Common-对象拷贝-Utils
 *
 * @author chengliang
 * @date 2020/7/2 13:15
 */
public class CopyUtils {

    /**
     * 拷贝Object
     *
     * @param source      源类
     * @param targetClazz 目标类class
     * @param <T>         目标类泛型
     * @param <S>         源类泛型
     * @return 目标类
     */
    public static <T, S> T copyObj(S source, Class<T> targetClazz) {
        if (source == null) {
            return null;
        }
        if (targetClazz == null) {
            return null;
        }
        try {
            T t = targetClazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(String.format("拷贝对象{%s}失败,由于{%s}类实例化失败,失去目标类", source.getClass().getName(), targetClazz.getName()));
        }
    }

    /**
     * 拷贝List
     *
     * @param sourceList  源类
     * @param targetClazz 目标类class
     * @param <T>         目标类泛型
     * @param <S>         源类泛型
     * @return 目标类
     */
    public static <T, S> List<T> copyList(List<S> sourceList, Class<T> targetClazz) {
        if (!CollectionUtils.isEmpty(sourceList)) {
            return null;
        }
        if (targetClazz == null) {
            return null;
        }
        return sourceList.stream().parallel().map(s -> CopyUtils.copyObj(s, targetClazz)).collect(Collectors.toList());
    }

}
