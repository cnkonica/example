package com.cnkonica.example.common;

import com.cnkonica.commons.result.ResultCode;

public enum BizResultCode implements ResultCode {
    SUCCESS("00000","操作成功"),
    REMOTE_ERROR("90001","远程错误"),
    ILLEGAL_ARGUMENT("90002","非法参数"),
    DATA_NOT_EXIST("90003","数据不存在"),
    SYSTEM_ERROR("99999","系统错误");
    private final String code;
    private final String message;


    BizResultCode(final String code, final String message) {
        this.code = code;
        this.message = message;

    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
