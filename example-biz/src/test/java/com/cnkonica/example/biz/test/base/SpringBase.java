package com.cnkonica.example.biz.test.base;

import com.cnkonica.example.api.ApiTestServiceFacade;
import com.cnkonica.example.biz.api.ApiTestServiceFacadeImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application-test.xml")
public class SpringBase {

}
