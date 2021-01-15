package com.cl.code;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author chengliang
 * @date 2021/1/15 9:49
 */
@Slf4j
public class DemoDataListener<T> extends AnalysisEventListener<T> {


    private List<T> collection;

    public DemoDataListener(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) {
        // 忽略异常
    }

    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {

    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        collection.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成-------------------");
    }

}
