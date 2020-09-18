package com.cl.msw.util.common;

import com.cl.msw.component.base.TreeData;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 构造树形工具
 *
 * @author chengliang
 * @date 2020/4/8 9:45
 */
public class TreeUtil {

    /**
     * 校验了死循环
     */
    public static <T extends TreeData<T>> List<T> toTree(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        Set<Long> idSet = new HashSet<>();
        List<T> tops = list.stream().filter(i -> StringUtils.isEmpty(i.getParentId()) || i.getParentId() == -1L).collect(Collectors.toList());
        tops.forEach(top -> {
            idSet.add(top.getId());
            addSubNodes(top, list, top.getId(), idSet);
        });
        return tops;
    }


    /**
     * 将树形结构转换为List
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends TreeData<T>> List<T> treeToList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<T> result = new ArrayList();
        for (T item : list) {
            result.add(item);
            if (!CollectionUtils.isEmpty(item.getChildren())) {
                List<T> childList = treeToList(item.getChildren());
                childList.forEach(childItem -> childItem.setParentId(item.getId()));
                result.addAll(childList);
            }
        }
        return result;
    }


    private static <T extends TreeData<T>> void addSubNodes(T t, List<T> list, Long id, Set<Long> idSet) {
        List<T> collect = list.stream().filter(i -> {
            if (id.equals(i.getParentId())) {
                if (idSet.contains(i.getId())) {
                    throw new RuntimeException("解析数据id,parentId错误导致解析时产生死循环");
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        collect.forEach(i -> {
            idSet.add(i.getId());
            addSubNodes(i, list, i.getId(), idSet);
        });
        t.setChildren(collect);
    }

}
