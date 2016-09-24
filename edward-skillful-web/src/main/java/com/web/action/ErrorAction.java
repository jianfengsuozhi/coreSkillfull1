package com.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Edward on 2016/9/23.
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorAction {

    @RequestMapping(value = "/404",method = RequestMethod.GET)
    public String error404(){
        return "error/404";
    }
}
