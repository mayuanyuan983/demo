package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/13/15:00
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(){

    }

}
