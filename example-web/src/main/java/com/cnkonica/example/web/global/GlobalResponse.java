package com.cnkonica.example.web.global;

import com.cnkonica.commons.result.ResultCode;
import com.cnkonica.example.common.BizResultCode;

import java.io.Serializable;

public class GlobalResponse<T> implements Serializable {
    private static final long serialVersionUID = -2511953664876840665L;
    private String code;
    private String message;
    private T data;
    public GlobalResponse() {

    }
    public GlobalResponse(String code) {
        this.code = code;
    }
    public GlobalResponse(String code,String msg) {
        this.code = code;
        this.message = msg;
    }
    public GlobalResponse(String code,String msg,T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public GlobalResponse<T> success(T data) {
        this.code = BizResultCode.SUCCESS.getCode();
        this.message = null;
        this.data = data;
        return this;
    }

    public GlobalResponse<T> success() {
        this.code = BizResultCode.SUCCESS.getCode();
        this.message = null;
        this.data = null;
        return this;
    }

    public GlobalResponse<T> error() {
        this.code = BizResultCode.SYSTEM_ERROR.getCode();
        this.message = BizResultCode.SYSTEM_ERROR.getMessage();
        this.data = null;
        return this;
    }

    public GlobalResponse<T> error(String message) {
        this.code = BizResultCode.SYSTEM_ERROR.getCode();
        this.message = message;
        this.data = null;
        return this;
    }
    public GlobalResponse<T> error(String code,String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        return this;
    }
    public GlobalResponse<T> error(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = null;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
