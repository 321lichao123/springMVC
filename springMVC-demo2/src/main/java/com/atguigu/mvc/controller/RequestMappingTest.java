package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "hello")
public class RequestMappingTest {

    @RequestMapping(value = {"target", "test"})
    public String toTarget() {
        return "target";
    }
}
