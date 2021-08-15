package com.cnkonica.example.biz.service.impl;

import com.cnkonica.example.biz.service.RunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RunServiceImpl implements RunService {
    private static final Logger looger = LoggerFactory.getLogger(RunServiceImpl.class);
    @Override
    public void run() {
        looger.info("RunServiceImpl run...");
    }
}
