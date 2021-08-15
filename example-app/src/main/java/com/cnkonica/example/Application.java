package com.cnkonica.example;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring-application.xml"})
@MapperScan(basePackages = "com.cnkonica.example.**.dao")
@Slf4j
public class Application {
    public static void main(String[] args) {
        log.info("example 启动开始 ==============");
        SpringApplication.run(Application.class,args);
        log.info("example 启动结束 ==============");
    }
}
