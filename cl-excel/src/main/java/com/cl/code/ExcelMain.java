package com.cl.code;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author chengliang
 * @date 2021/1/14 17:16
 */
public class ExcelMain {


    public <T> List<T> doRead(Class<T> clazz) {


        File file = new File("C:\\Users\\EDZ\\Desktop\\《槲寄生测试项目-111-222 (指标)》.xlsx");
        List<T> collection = new ArrayList<>();


        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream2 = new FileInputStream(file);

            DemoHeadInfo demoHeadInfo = new DemoHeadInfo();
            // 获取传入clazz上携带的HeadLabel
            // 第一次读取 确定head的rowIndex
            EasyExcel.read(fileInputStream, new DemoHeadListener(demoHeadInfo, getHeadLabels(clazz))).headRowNumber(0).sheet(0).doRead();


            // 第二次读取 确定表体数据
            EasyExcel.read(fileInputStream2, clazz, new DemoDataListener<>(collection))
                    .headRowNumber(demoHeadInfo.getHeadIndex())
                    .sheet(0)
                    .doRead();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private <T> List<String> getHeadLabels(Class<T> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();

        return Arrays.stream(declaredFields)
                .filter(field -> field.isAnnotationPresent(ExcelProperty.class))
                .map(field -> {
                    String[] value = field.getAnnotation(ExcelProperty.class).value();
                    return value[value.length - 1];
                })
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        ExcelMain excelMain = new ExcelMain();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1; i++) {
            fixedThreadPool.execute(() -> {
                List<DemoData> demoData = excelMain.doRead(DemoData.class);
                System.out.println(demoData);
            });
        }
    }

}
