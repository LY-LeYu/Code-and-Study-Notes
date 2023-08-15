package com.example.springboot_web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String testOne() {
        return "fmm.jpg";
    }
}
