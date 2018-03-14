package com.wq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qwu on 2018/3/14.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello wuqingvika";
    }
}
