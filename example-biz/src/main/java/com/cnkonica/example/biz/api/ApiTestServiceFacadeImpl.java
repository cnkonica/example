package com.cnkonica.example.biz.api;

import com.cnkonica.example.api.ApiTestServiceFacade;
import com.cnkonica.example.biz.service.RunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ApiTestServiceFacadeImpl implements ApiTestServiceFacade {
    private static final Logger logger = LoggerFactory.getLogger(ApiTestServiceFacadeImpl.class);
    private final RunService runService;
    public ApiTestServiceFacadeImpl(RunService runService) {
        this.runService = runService;
    }
    @Override
    public void run() {
        logger.info("ApiTestServiceFacadeImpl run..");
        runService.run();
    }
}
