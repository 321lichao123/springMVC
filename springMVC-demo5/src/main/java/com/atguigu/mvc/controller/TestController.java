package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description
 * @Author 12468
 * @Date 2021/12/28 23:16
 * @Version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 /0);
        return "success";
    }
}
