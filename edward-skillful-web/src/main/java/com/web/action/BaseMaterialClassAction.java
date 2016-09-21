package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.BaseMaterialClassService;
import com.exception.MyException;
import com.provider.model.BaseMaterialClass;
import com.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(BaseMaterialClassAction.class);
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

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public JsonData save(
             @ModelAttribute BaseMaterialClass baseMaterialClass) {
        if (null == baseMaterialClass.getClassId()){
            baseMaterialClass.setParentHospitalId(1);
        }
        try {
            baseMaterialClassService.save(baseMaterialClass);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        //若为redirect:baseMaterialClass/list.htm 则地址变成 http://localhost:8089/edward-skillful-web/baseMaterialClass/baseMaterialClass/list.htm
        //若为redirect:list.htm 则正确
        return JsonData.getSucceed();
    }

    @RequestMapping(value = "/toModify",method = RequestMethod.GET)
    public String toModify(
            @RequestParam(value = "classId",required = true)Integer classId,ModelMap modelMap){
        modelMap.addAttribute("baseMaterialClass",baseMaterialClassService.selectById(classId));
        return "baseMaterialClass/addOrUpdate";
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public JsonData delete(
            @RequestParam(value = "classId",required = true)Integer classId) {
        try {
            baseMaterialClassService.delete(classId);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed("删除失败");
        }
        return JsonData.getSucceed();
    }

}
