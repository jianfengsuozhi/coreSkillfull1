package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.BaseMaterialClassService;
import com.api.service.BaseMaterialService;
import com.exception.MyException;
import com.exception.MyObjectNullException;
import com.provider.model.BaseMaterial;
import com.utils.JsonData;
import com.utils.WebUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * 物资分类
 * Created by Edward on 2016/9/26.
 */
@Controller
@RequestMapping("/baseMaterial")
public class BaseMaterialAction {
    private Logger logger = LoggerFactory.getLogger(BaseMaterialAction.class);
    @Resource
    private BaseMaterialService baseMaterialService;
    @Resource
    private BaseMaterialClassService baseMaterialClassService;

    /**
     * 第一次进入
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/defaultList",method = RequestMethod.GET)
    public String defaultList(ModelMap modelMap,ServletRequest request){
        this.commonList(null,null,null,modelMap,request);
        return "baseMaterial/list";
    }

    /**
     * 查询
     * @param materialName
     * @param classCode
     * @param pageNo
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "materialName",required = false)String materialName,
            @RequestParam(value = "classCode",required = false)String classCode,
            @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
            ModelMap modelMap,ServletRequest request){
        this.commonList(materialName,classCode,pageNo,modelMap,request);
        return "baseMaterial/list";
    }

    private void commonList(String materialName,String classCode,Integer pageNo,ModelMap modelMap,ServletRequest request) {
        PageList<BaseMaterial> pageList = baseMaterialService.pageList(materialName, classCode, new Page(pageNo, Page.DefaultPageSize), 1);
        modelMap.addAttribute("list", pageList.getListData());
        modelMap.addAttribute("page", pageList.getPage());

        Map<String, Object> params = WebUtility.getParametersStartingWith(request, null);
        params.put("pageNo", pageList.getPage().getPageIndex());
        modelMap.addAttribute("params", params);
        modelMap.addAttribute("materialClasses", baseMaterialClassService.selectAllCodeAndName(1));
    }

    /**
     * 去新增
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(ServletRequest request,ModelMap modelMap){
        modelMap.addAttribute("params", WebUtility.getParametersStartingWith(request, null));
        return "baseMaterial/addAndUpdate";
    }

    /**
     * 插入或更新
     * @param baseMaterial
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public JsonData save(
            @ModelAttribute BaseMaterial baseMaterial){
        if(null == baseMaterial.getMaterialId()){
            baseMaterial.setParentHospitalId(1);
        }
        try {
            baseMaterialService.save(baseMaterial);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed("插入或更新成功");
    }

    /**
     * 去修改
     * @param materialId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toModify",method = RequestMethod.GET)
    public String toModify(
            @RequestParam(value = "materialId",required = true)Integer materialId,
            ServletRequest request,
            ModelMap modelMap){
        BaseMaterial baseMaterial = baseMaterialService.selectById(materialId);
        MyObjectNullException.checkNull(baseMaterial,logger,"主键是"+materialId+"的对象不存在");
        modelMap.addAttribute("baseMaterial", baseMaterial);
        modelMap.addAttribute("params", WebUtility.getParametersStartingWith(request, null));
        return "baseMaterial/addAndUpdate";
    }

    /**
     * 查看
     * @param materialId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "materialId",required = true)Integer materialId,
            ModelMap modelMap){
        BaseMaterial baseMaterial = baseMaterialService.selectById(materialId);
        MyObjectNullException.checkNull(baseMaterial,logger,"主键是"+materialId+"的对象不存在");
        modelMap.addAttribute("baseMaterial", baseMaterial);
        return "baseMaterial/view";
    }

    /**
     * 删除
     * @param materialId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public JsonData delete(
            @RequestParam(value = "materialId",required = true)Integer materialId){
        try {
            baseMaterialService.delete(materialId);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed("删除成功");
    }

}

