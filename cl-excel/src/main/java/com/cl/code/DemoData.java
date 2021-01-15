package com.cl.code;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengliang
 * @date 2021/1/15 9:49
 */
@Data
public class DemoData {

    @ExcelProperty("序号")
    private String index;

    @ExcelProperty("主要分项工程")
    private String name;

    @ExcelProperty("工程造价（元）")
    private BigDecimal cost;

    @ExcelProperty("建筑面积（㎡）")
    private BigDecimal area;

    @ExcelProperty("备注")
    private String remark;

}