package com.atguigu.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index() {
        // 返回的试图
        return "index";
    }

    @RequestMapping(value = "/target")
    public String toTarget() {
        return "target";
    }
}
