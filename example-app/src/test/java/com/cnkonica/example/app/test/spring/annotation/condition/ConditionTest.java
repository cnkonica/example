package com.cnkonica.example.app.test.spring.annotation.condition;

import com.cnkonica.example.app.test.base.SpringBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

@Slf4j
public class ConditionTest extends SpringBase {
    @Autowired
    ApplicationContext context ;

    @Test
    public void test01(){
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        log.info("{}",beansOfType);
    }


    @Test
    public void test02(){
        Map<String, Computer> beansOfType = context.getBeansOfType(Computer.class);
        log.info("{}",beansOfType);
    }

}
