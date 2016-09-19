package com.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Edward on 2016/9/19.
 */
@Controller
public class Index {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
