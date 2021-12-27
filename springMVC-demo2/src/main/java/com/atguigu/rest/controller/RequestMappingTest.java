package com.atguigu.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "hello")
public class RequestMappingTest {

    @RequestMapping(
            value = {"target", "test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String toTarget() {
        return "target";
    }

    @RequestMapping(
            value = "/testParamsAndHeader",
            params = {"username"}
    )
    public String testParamsAndHeader() {
        return "target";
    }

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt() {
        return "target";
    }

    @RequestMapping("testPath/{id}")
    public String testPath(@PathVariable("id")Integer id) {
        System.out.println("id：" + id);
        return "target";
    }
}
