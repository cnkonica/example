package com.cnkonica.example.web.global;

import base.GlobalResponse;
import com.cnkonica.commons.exception.CommonException;
import com.cnkonica.example.biz.utils.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, Exception.class, RuntimeException.class,
            HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<GlobalResponse> handleException(Exception ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        GlobalResponse<Object> response = Results.error("服务器异常，请联系管理员");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(response);
    }

    public GlobalResponse businessException(CommonException e) {
        logger.error(e.getMessage(), e);
        return Results.error(e.getCode(),e.getMessage());

    }


}
