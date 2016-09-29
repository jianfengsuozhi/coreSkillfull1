package com.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Edward on 2016/9/29.
 */
@Controller
public class Login {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "error",required = false)String error,
            @RequestParam(value = "logout",required = false)String logout, ModelMap modelMap){
        if(null != error){
            modelMap.addAttribute("error","Invalid username and password!");
        }
        if(null != logout){
            modelMap.addAttribute("logout", "You have been logout!");
        }
        return "login";
    }

    @RequestMapping("/deny")
    @ResponseBody
    public String handleDeny() {
        return "Have not enough permission!";
    }
}
