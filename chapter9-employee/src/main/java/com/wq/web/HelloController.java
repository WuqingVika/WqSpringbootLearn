package com.wq.web;

import com.wq.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wuqingvika on 2018/3/20.
 */
@Controller
public class HelloController {
    @RequestMapping({"/"})
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hellowq")
    public  String hello(@RequestParam("user") String user){
        System.out.print("wqhhlll");
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }
}
