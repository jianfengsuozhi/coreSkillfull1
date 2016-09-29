package com.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Edward on 2016/9/29.
 */
@Controller
public class Login {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username",required = true)String username,
            @RequestParam(value = "password",required = true)String password){
        return "redirect:index";
    }
}
