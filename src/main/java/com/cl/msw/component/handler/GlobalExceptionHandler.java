package com.cl.msw.component.handler;

import com.cl.msw.component.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Msw-全局异常捕获处理器-Handler
 *
 * @author chengliang
 * @date 2020/7/2 16:31
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 其他异常处理器
     *
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(Exception.class)
    public Result<Object> defaultExceptionHandler(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }

    /**
     * 参数校验失败异常
     *
     * @param e MethodArgumentNotValidException
     * @return ApiResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object defaultExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }

}
