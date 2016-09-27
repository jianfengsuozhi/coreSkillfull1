package com.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by weideliang on 2016/9/27.
 */
@Controller
@RequestMapping("/test/bounced")
public class TestBounced {

    @RequestMapping(value = "/{path}",method = RequestMethod.GET)
    public String index(@PathVariable String path){
        return "test/bounced/"+path;
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String page(){
        return "/WEB-INF/views/test/bounced/page.html";
    }

}
