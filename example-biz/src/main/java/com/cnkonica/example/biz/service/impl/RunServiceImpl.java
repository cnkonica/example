package com.cnkonica.example.biz.service.impl;

import com.cnkonica.example.biz.service.RunService;
import com.cnkonica.example.dao.primary.mybatis.mapper.UserDOMapper;
import com.cnkonica.example.dao.primary.mybatis.pojo.UserDO;
import com.cnkonica.example.dao.secondary.mybatis.mapper.EmployeeDOMapper;
import com.cnkonica.example.dao.secondary.mybatis.pojo.EmployeeDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class RunServiceImpl implements RunService {
    private static final Logger looger = LoggerFactory.getLogger(RunServiceImpl.class);
    @Resource
    private UserDOMapper userDOMapper;
    @Resource
    private EmployeeDOMapper employeeDOMapper;
    @Override
    public String run() {
        looger.info("RunServiceImpl run...");
        UserDO userDO = new UserDO();
        userDO.setName("konyliu");
        userDOMapper.insertSelective(userDO);
        return "成功";
    }

    @Override
    public String pgTest() {
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setCertId(UUID.randomUUID().toString().replace("-",""));
        employeeDOMapper.insertSelective(employeeDO);
        return "成功";
    }


}
