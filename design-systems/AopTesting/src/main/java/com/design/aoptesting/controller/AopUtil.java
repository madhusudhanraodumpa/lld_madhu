package com.design.aoptesting.controller;

import org.springframework.stereotype.Service;

@Service
public class AopUtil {
    public void helperMethod() {
        System.out.println("helping method..");
    }
}
