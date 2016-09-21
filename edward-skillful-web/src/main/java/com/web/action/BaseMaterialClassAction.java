package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.BaseMaterialClassService;
import com.exception.MyException;
import com.provider.model.BaseMaterialClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Created by Edward on 2016/9/18.
 */
@Controller
@RequestMapping("/baseMaterialClass")
public class BaseMaterialClassAction {
    @Resource
    private BaseMaterialClassService baseMaterialClassService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "className",required = false)String className,
            ModelMap modelMap){
        PageList<BaseMaterialClass> pageList = baseMaterialClassService.pageList(null, new Page(1, 10));
        modelMap.addAttribute("pageList",pageList.getListData());
        modelMap.addAttribute("page",pageList.getPage());
        return "baseMaterialClass/list";
    }

    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "baseMaterialClass/addOrUpdate";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(
             @ModelAttribute BaseMaterialClass baseMaterialClass) throws MyException {
        if (null == baseMaterialClass.getClassId()){
            baseMaterialClass.setParentHospitalId(1);
        }
        baseMaterialClassService.save(baseMaterialClass);
        return "redirect:baseMaterialClass/list.htm";
    }

    @RequestMapping(value = "/toModify",method = RequestMethod.GET)
    public String toModify(
            @RequestParam(value = "classId",required = true)Integer classId,ModelMap modelMap){
        modelMap.addAttribute("baseMaterialClass",baseMaterialClassService.selectById(classId));
        return "baseMaterialClass/addOrUpdate";
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public void   delete(
            @RequestParam(value = "classId",required = true)Integer classId) throws MyException {
        baseMaterialClassService.delete(classId);
    }

}
