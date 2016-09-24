package com.web.test;

import com.provider.model.BaseMaterialClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Edward on 2016/9/24.
 */
@Controller
@RequestMapping(value = "/test/data")
public class FormObjController {

    @RequestMapping("/test1")
    public String test1(@FormObj User user) {
        return "test/data/index";
    }

    @RequestMapping("/test2")
    public String test2(@FormObj("u") User user, @FormObj("b") BaseMaterialClass baseMaterialClass) {
        return "test/data/index";
    }

    @RequestMapping("/test3")
    public String test3(@FormObj(value = "d", show = false) User user, @FormObj("e") BaseMaterialClass baseMaterialClass) {
        return "test/data/index";
    }

}