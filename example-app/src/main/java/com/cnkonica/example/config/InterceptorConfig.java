package com.cnkonica.example.config;


import com.cnkonica.example.interceptor.InvocationTraceInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorConfig {
    public static final String TRACE_PATH="execution(public * com.cnkonica.example.service.impl..*.*(..))";

    @Bean
    public DefaultPointcutAdvisor implPointcutAdvisor(InvocationTraceInterceptor interceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(TRACE_PATH);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }

    @Bean
    public InvocationTraceInterceptor invocationTraceInterceptor(){
        return new InvocationTraceInterceptor();
    }

}
