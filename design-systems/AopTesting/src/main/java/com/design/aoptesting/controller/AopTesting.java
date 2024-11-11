package com.design.aoptesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AopTesting {
    @Autowired
    private AopUtil aopUtil;
    @GetMapping(path = "/fetchEmployee")
    public String fetchEmployee() {
        aopUtil.helperMethod();
      return "employee fetched.";
    }
}
