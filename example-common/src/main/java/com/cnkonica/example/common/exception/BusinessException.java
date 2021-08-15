package com.cnkonica.example.common.exception;

import com.cnkonica.commons.exception.CommonException;
import com.cnkonica.example.common.BizResultCode;


public class BusinessException extends CommonException {
    private static final long serialVersionUID = 1L;
    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(BizResultCode bizResultCode) {
        super(bizResultCode);
    }
    public BusinessException(String message) {
        this(BizResultCode.SYSTEM_ERROR.getCode(), message);
    }
    public BusinessException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
