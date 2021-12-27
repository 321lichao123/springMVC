package com.atguigu.rest.controller;

import com.atguigu.rest.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class paramController {

    @RequestMapping(value = "/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ", password:" + password);
        return "success";
    }

    @RequestMapping(value = "/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "haha") String username,
            String password,
            String[] hobby,
            @RequestHeader("Host") String host
    ) {
        // 请求参数中出现多个同名参数，可以在控制器方法中设置字符串类型或者字符串数组接受此参数
        System.out.println("username:" + username + ", password:" + password + ", hobby:" + Arrays.toString(hobby));
        System.out.println("Host:" + host);
        return "success";
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
