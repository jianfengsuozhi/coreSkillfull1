package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.BaseMaterialClassService;
import com.exception.MyException;
import com.google.common.collect.Maps;
import com.provider.model.BaseMaterialClass;
import com.utils.DateUtils;
import com.utils.JsonData;
import com.utils.WebUtility;
import com.web.util.SearchParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.LinkedHashMap;


/**
 * 物资分类
 * Created by Edward on 2016/9/18.
 */
@Controller
@RequestMapping("/baseMaterialClass")
@PreAuthorize("hasAnyRole('2')")
public class BaseMaterialClassAction {
    private Logger logger = LoggerFactory.getLogger(BaseMaterialClassAction.class);
    @Resource
    private BaseMaterialClassService baseMaterialClassService;

    @RequestMapping(value = "/defaultList",method = RequestMethod.GET)
    public String defaultList(@SearchParam BaseMaterialClassSearchCondition condition,ModelMap modelMap){
        condition.reset();
        this.commonList(condition,modelMap);
        return "baseMaterialClass/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(
            @SearchParam BaseMaterialClassSearchCondition condition,
            ModelMap modelMap){
        commonList(condition, modelMap);
        return "baseMaterialClass/list";
    }

    private void commonList(BaseMaterialClassSearchCondition condition, ModelMap modelMap) {
        PageList<BaseMaterialClass> pageList = baseMaterialClassService.pageList(condition.getClassName(), new Page(condition.getPageNo(), Page.DefaultPageSize));
        modelMap.addAttribute("pageList",pageList.getListData());
        modelMap.addAttribute("page",pageList.getPage());
        modelMap.addAttribute("condition", condition);
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

    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "classId",required = true)Integer classId,ModelMap modelMap){
        modelMap.addAttribute("baseMaterialClass",baseMaterialClassService.selectById(classId));
        return "baseMaterialClass/view";
    }

    /**
     * 下载
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/download",method = {RequestMethod.POST,RequestMethod.GET})
    public JsonData download(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Date date = DateUtils.getCurDate();
        String exportName = DateUtils.toStr("yyyyMMdd", date) + "--" + DateUtils.toStr("yyyyMMdd", date) + "物资类别信息.xls";
        LinkedHashMap<String, Object> maps = Maps.newLinkedHashMap();
        maps.put("materialClassList", baseMaterialClassService.selectAll());
        maps.put("isFirstPage", true);
        WebUtility.exportToDownload(response,request,maps,exportName,"bms-template.xls",1);
        return JsonData.getSucceed();
    }

   public static class BaseMaterialClassSearchCondition {
       private Integer pageNo = 1;
       private String className;

       public BaseMaterialClassSearchCondition() {

       }

       public void reset(){
           setClassName(null);
       }

       public Integer getPageNo() {
           return pageNo;
       }

       public void setPageNo(Integer pageNo) {
           this.pageNo = pageNo;
       }

       public String getClassName() {
           return className;
       }

       public void setClassName(String className) {
           this.className = className;
       }
   }
}
