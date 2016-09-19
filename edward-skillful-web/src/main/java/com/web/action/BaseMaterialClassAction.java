package com.web.action;

import com.api.page.Page;
import com.api.service.BaseMaterialClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Edward on 2016/9/18.
 */
@RequestMapping("/baseMaterialClass")
@Controller
public class BaseMaterialClassAction {
    @Resource
    private BaseMaterialClassService baseMaterialClassService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "className",required = false)String className,
            ModelMap modelMap){
        modelMap.addAttribute("pageList",baseMaterialClassService.pageList(null,new Page(1,10)));
        return "baseMaterialClass/list";
    }


}
