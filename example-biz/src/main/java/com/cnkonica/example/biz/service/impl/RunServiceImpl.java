package com.cnkonica.example.biz.service.impl;

import com.cnkonica.example.biz.service.RunService;
import com.cnkonica.example.repository.mapper.UserDOMapper;
import com.cnkonica.example.repository.pojo.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RunServiceImpl implements RunService {
    private static final Logger looger = LoggerFactory.getLogger(RunServiceImpl.class);
    @Resource
    private UserDOMapper userDOMapper;
    @Override
    public String run() {
        looger.info("RunServiceImpl run...");
        UserDO userDO = new UserDO();
        userDO.setUsername("konyliu");
        userDOMapper.insertSelective(userDO);
        return "成功";
    }
}
