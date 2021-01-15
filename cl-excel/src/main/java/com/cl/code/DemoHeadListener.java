package com.cl.code;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;
import java.util.Map;

/**
 * @author chengliang
 * @date 2021/1/15 15:49
 */
public class DemoHeadListener extends AnalysisEventListener<Map<String, String>> {

    private final DemoHeadInfo headInfo;

    private final List<String> headLabels;


    public DemoHeadListener(DemoHeadInfo headInfo, List<String> headLabels) {
        this.headInfo = headInfo;
        this.headLabels = headLabels;
    }

    @Override
    public void invoke(Map<String, String> data, AnalysisContext context) {

        if (!headInfo.isPresent()) {
            if (this.headLabels.stream().allMatch(data::containsValue)) {
                headInfo.setHeadIndex(context.readRowHolder().getRowIndex() + 1);
                headInfo.setPresent(true);
            }
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!headInfo.isPresent()) {
            throw new RuntimeException("未找到对应的头部");
        }
    }

}
