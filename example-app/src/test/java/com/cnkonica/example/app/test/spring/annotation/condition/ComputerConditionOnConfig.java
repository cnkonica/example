package com.cnkonica.example.app.test.spring.annotation.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConditionOnConfig {

    //@Bean("notebook")
    public Computer computer1(){
        return new Computer("notebook");
    }

    @Bean("reservePC")
    @ConditionalOnMissingBean(Computer.class)
    public Computer computer2(){
        return new Computer("reservePC");
    }
}
