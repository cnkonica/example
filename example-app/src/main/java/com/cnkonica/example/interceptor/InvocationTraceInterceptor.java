package com.cnkonica.example.interceptor;


import com.alibaba.fastjson.JSON;
import com.cnkonica.example.common.exception.BusinessException;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InvocationTraceInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(InvocationTraceInterceptor.class);
    private static final String ERROR_LOG_TEMPLATE = "invoke:{}.{},code:{},message:{},input:{},begin:{},elapsed:{}ms";
    private static final String INPUT_LOG_TEMPLATE = "invoke:{}.{},input:{}";
    private static final String OUTPUT_LOG_TEMPLATE = "invoke:{}.{},output:{},begin:{},elapsed:{}ms";
    private static final DateTimeFormatter DATE_TIME_FORMATTER= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final LocalDateTime begin = LocalDateTime.now();
        this.logInput(invocation);
        final Object result;
        try {
            result = invocation.proceed();
        } catch (final BusinessException e) {
            this.logError(invocation, begin, e.getCode(), e.getMessage());
            throw e;
        } catch (final Exception e) {
            this.logError(invocation, begin, "EXCEPTION", e.getMessage());
            throw e;
        } catch (final Throwable e) {
            this.logError(invocation, begin, "Throwable", e.getMessage());
            throw e;
        }
        this.logOut(invocation, begin, result);
        return result;
    }

    private void logOut(MethodInvocation invocation, LocalDateTime beginTime, Object data) {
        final String begin = DATE_TIME_FORMATTER.format(beginTime);
        final long elasped = Duration.between(beginTime, LocalDateTime.now()).toMillis();
        final Method method = invocation.getMethod();
        final String className = method.getDeclaringClass().getSimpleName();
        final String methodName = method.getName();
        String resultString = data == null ? StringUtils.EMPTY : JSON.toJSONString(data);
        logger.info(OUTPUT_LOG_TEMPLATE,className,methodName,resultString,begin,elasped);
    }

    private void logError(MethodInvocation invocation, LocalDateTime beginTime, String code, String message) {
        final String begin = DATE_TIME_FORMATTER.format(beginTime);
        final long elasped = Duration.between(beginTime, LocalDateTime.now()).toMillis();
        final Method method = invocation.getMethod();
        final String className = method.getDeclaringClass().getSimpleName();
        final String methodName = method.getName();
        Object[] arguments = invocation.getArguments();
        String argStr = ArrayUtils.isEmpty(arguments) ? StringUtils.EMPTY : Arrays.stream(arguments).map(param -> {
            if (param instanceof Byte) {
                return StringUtils.EMPTY;
            }
            return JSON.toJSONString(param);
        }).collect(Collectors.joining(","));
        logger.error(ERROR_LOG_TEMPLATE,className,methodName,code,message,argStr,begin,elasped);
    }

    private void logInput(MethodInvocation invocation) {
        final Method method = invocation.getMethod();
        final String className = method.getDeclaringClass().getSimpleName();
        final String methodName = method.getName();
        Object[] arguments = invocation.getArguments();
        String argStr = ArrayUtils.isEmpty(arguments) ? StringUtils.EMPTY : Arrays.stream(arguments).map(param -> {
            if (param instanceof Byte) {
                return StringUtils.EMPTY;
            }
            return JSON.toJSONString(param);
        }).collect(Collectors.joining(","));
        logger.info(INPUT_LOG_TEMPLATE,className,methodName,argStr);
    }

}
