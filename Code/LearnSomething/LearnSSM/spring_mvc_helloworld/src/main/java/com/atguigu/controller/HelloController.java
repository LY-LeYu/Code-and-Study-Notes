package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/")
    public String Hello(){
        return "Hello";
    }
}
