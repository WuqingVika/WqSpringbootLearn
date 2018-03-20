package com.wq.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wuqingvika on 2018/3/20.
 */
@Controller
public class HelloController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "login";
    }
}
