package com.cl.msw.component.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author chengliang
 * @date 2020/7/1 14:15
 */
public interface MswBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
