package com.cnkonica.example.app.test.spring.annotation.configprop;

import com.alibaba.fastjson.JSON;
import com.cnkonica.example.app.test.base.SpringBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


/**在SpringBoot中，我们可以通过以下几种方式获取并绑定配置文件中的信息：
@Value注解。
使用Environment。
@ConfigurationProperties注解。
通过实现ApplicationListener接口，注册监听器，进行硬编码获取，可参考https://blog.csdn.net/thc1987/article/details/78789426。
硬编码加载文件获取。
注：一般情况下，第一种、第二种就够用了;但是如果想直接从配置文件中获取到数组、list、map、对象的话，
第一种和第二种的支持性不太好，目前只能获取到数组、list，对map、bean的话，就有点束手无策了。
这时我们可以使用第三种方式进行获取。*/

@Slf4j
public class ConfigTest extends SpringBase {
    @Autowired
    private PopProperties popProperties;
    @Autowired
    private Environment environment;
    @Test
    public void test01(){
        log.info("{}", JSON.toJSONString(popProperties));
    }
    @Test
    public void test02(){
        String property = environment.getProperty("app.normalBoolean");
        log.info("{}",property);

    }
}
