package com.wq.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuqingvika on 2018/3/17.
 */
@RestController
public class HelloController {
    @Value("${person.name}")
    private String name;
    @RequestMapping("/hellow")
    public String testHello(){
        return  name;
    }
}
