package com.cl.msw.component.base;

import java.util.List;

/**
 * Msw-树模型
 *
 * @author chengliang
 * @date 2020/7/2 14:17
 */
public interface TreeData<T> {

    /**
     * id
     *
     * @return id
     */
    Long getId();

    /**
     * id
     *
     * @param id id
     */
    void setId(Long id);

    /**
     * parentId
     *
     * @return parentId
     */
    Long getParentId();

    /**
     * parentId
     *
     * @param id parentId
     */
    void setParentId(Long id);

    /**
     * children
     *
     * @return children
     */
    List<T> getChildren();

    /**
     * children
     *
     * @param children children
     */
    void setChildren(List<T> children);
}
