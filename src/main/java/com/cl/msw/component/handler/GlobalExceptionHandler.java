package com.cl.msw.component.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Msw-全局异常捕获处理器-Handler
 *
 * @author chengliang
 * @date 2020/7/2 16:31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 其他异常处理器
     *
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(Exception.class)
    public Object defaultExceptionHandler(Exception e) {
        return null;
    }

}
