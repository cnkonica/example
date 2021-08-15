package com.cnkonica.example.biz.test.api;

import com.cnkonica.example.api.ApiTestServiceFacade;
import com.cnkonica.example.biz.test.base.SpringBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiTest extends SpringBase {
    @Autowired
    ApiTestServiceFacade apiTestServiceFacade;
    @Test
    public void runTest(){
        apiTestServiceFacade.run();
    }
}
