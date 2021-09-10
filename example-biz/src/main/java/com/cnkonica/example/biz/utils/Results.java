package com.cnkonica.example.biz.utils;

import base.GlobalResponse;
import com.cnkonica.commons.result.ResultCode;
import com.cnkonica.example.common.BizResultCode;

public class Results {
    private Results(){}

    private static <T> GlobalResponse<T> of(String code, String message, T t) {
        return new GlobalResponse<>(code, message, t);
    }
    public static <T> GlobalResponse<T> success(T data) {
        return Results.of(BizResultCode.SUCCESS.getCode(), BizResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> GlobalResponse<T> success() {
        return Results.of(BizResultCode.SUCCESS.getCode(), BizResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> GlobalResponse<T> error() {
        return Results.of(BizResultCode.SYSTEM_ERROR.getCode(), BizResultCode.SYSTEM_ERROR.getMessage(), null);
    }

    public static <T> GlobalResponse<T> error(String message) {
        return Results.of(BizResultCode.SYSTEM_ERROR.getCode(), message, null);
    }
    public static <T> GlobalResponse<T> error(String code,String message) {
        return Results.of(code, message, null);
    }
    public static <T> GlobalResponse<T> error(ResultCode resultCode) {
        return Results.of(resultCode.getCode(), resultCode.getMessage(), null);
    }
}
