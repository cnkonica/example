package com.cnkonica.example.web.global;

import base.GlobalResponse;
import com.cnkonica.example.biz.utils.Results;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        String returnTypeName = returnType.getParameterType().getName();
        return !GlobalResponse.class.getName().equals(returnTypeName) &&
                !ResponseEntity.class.getName().equals(returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        String returnTypeName = returnType.getParameterType().getName();
        if ("void".equals(returnTypeName)) {
            return Results.success();
        }
        if (!MediaType.APPLICATION_JSON.equals(selectedContentType)) {
            return body;
        }

        if (GlobalResponse.class.getName().equals(returnTypeName)) {
            return body;
        }
        return Results.success(body);

    }
}
