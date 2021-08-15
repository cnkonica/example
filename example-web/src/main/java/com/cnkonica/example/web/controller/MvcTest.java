package com.cnkonica.example.web.controller;

import com.cnkonica.example.biz.service.RunService;
import com.cnkonica.example.web.global.GlobalResponse;
import com.cnkonica.example.web.global.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvctest")
public class MvcTest {
    @Autowired
    private RunService runService;

    @RequestMapping("/simpleTest")
    public GlobalResponse simpleTest(){
        int i = 1 / 0;
        return Results.success("成功");
    }
    @RequestMapping("/runServiceTest")
    public GlobalResponse runServiceTest(){
        runService.run();
        return Results.success();
    }
}
