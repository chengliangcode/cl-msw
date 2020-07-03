package com.cl.msw.component.base;

import lombok.Data;

/**
 * 返回结果封装
 *
 * @author chengliang
 * @date 2020/7/3 15:47
 */
@Data
public class Result<T> {

    /**
     * code
     */
    private final Integer code;

    /**
     * 消息
     */
    private final String message;

    /**
     * 视图数据
     */
    private final T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(ResultSuccessMsgEnum resultMsgEnum, T data) {
        this.code = resultMsgEnum.getCode();
        this.message = resultMsgEnum.getDesc();
        this.data = data;
    }

    private Result(ResultFailMsgEnum resultMsgEnum, T data) {
        this.code = resultMsgEnum.getCode();
        this.message = resultMsgEnum.getDesc();
        this.data = data;
    }

    public static Result<Object> success() {
        return new Result<>(ResultSuccessMsgEnum.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultSuccessMsgEnum.SUCCESS, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultFailMsgEnum.FAIL, data);
    }

    public static <T> Result<T> fail(ResultFailMsgEnum failMsgEnum) {
        return Result.fail(failMsgEnum, null);
    }

    public static <T> Result<T> fail(ResultFailMsgEnum failMsgEnum, T data) {
        return new Result<T>(failMsgEnum, data);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<T>(ResultFailMsgEnum.FAIL.getCode(), message, data);
    }

}
