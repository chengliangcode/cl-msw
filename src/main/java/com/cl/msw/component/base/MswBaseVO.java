package com.cl.msw.component.base;

import lombok.Data;

/**
 * Msw-基础-VO
 *
 * @author chengliang
 * @date 2020/7/2 10:34
 */
@Data
public class MswBaseVO {

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 创建人id
     */
    private Long createPersonId;

    /**
     * 创建人名称
     */
    private String createPersonName;

    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 最后更新人id
     */
    private Long updatePersonId;

    /**
     * 最后更新人名称
     */
    private String updatePersonName;

}
