package com.web.test;

import com.web.util.SearchParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Edward on 2016/9/24.
 */
@Controller
@RequestMapping("/test/data")
public class TestDataBinding {
    @RequestMapping("/index")
    public String index(){
        return "test/data/index";
    }

    //3
    @RequestMapping("/nameP")
    public String data(@SearchParam String name){
        System.out.println("参数");
        return "test/data/index";
    }
}
