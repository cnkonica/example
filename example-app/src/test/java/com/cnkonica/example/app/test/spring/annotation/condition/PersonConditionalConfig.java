package com.cnkonica.example.app.test.spring.annotation.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
//第一个条件类实现的方法返回true，第二个返回false，则结果false，不注入进容器。
//第一个条件类实现的方法返回true，第二个返回true，则结果true，注入进容器中。
@Conditional({WindowCondition.class,LinuxCondition.class}) // 为false
public class PersonConditionalConfig {
    @Bean(value = "bill")
    //@Conditional(WindowCondition.class)
    public Person person1(){
        return new Person("bill gate",62);
    }

    @Bean(value = "linus")
    //@Conditional(LinuxCondition.class)
    public Person person2(){
        return new Person("linus", 48);
    }
}
