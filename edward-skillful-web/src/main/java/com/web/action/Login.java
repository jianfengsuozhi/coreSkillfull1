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

    /**
     * username和password spring自动验证
     * @param error
     * @param logout
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(
            @RequestParam(value = "error",required = false)String error,
            @RequestParam(value = "logout",required = false)String logout, ModelMap modelMap){
        if(null != error){
            modelMap.addAttribute("error","Invalid username and password!"); //若验证失败,出现这种提示
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
