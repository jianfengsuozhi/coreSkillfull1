package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.BaseMaterialClassService;
import com.api.service.BaseMaterialService;
import com.exception.MyException;
import com.exception.MyObjectNullException;
import com.provider.model.BaseMaterial;
import com.utils.JsonData;
import com.web.util.SearchParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 物资
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
     * 测试四种url
     * ServletRequest 接口
     * HttpServletRequest 继承ServletRequest的接口
     * WebRequest 针对请求拦截器
     * @param servletRequest
     */
    public void testURL(ServletRequest servletRequest){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURL());// http://localhost:8080/edward-skillful-web/baseMaterial/list.htm
        System.out.println(request.getRequestURI());// /edward-skillful-web/baseMaterial/list.htm context+servlet
        System.out.println(request.getServletPath());// /baseMaterial/list.htm 对话
        System.out.println(request.getContextPath());// /edward-skillful-web 项目
        System.out.println(request.getRealPath("/"));// D:\java\IdeaProjects\coreSkillfull\edward-skillful-web\target\edward-skillful-web\
    }

    /**
     * 第一次进入
     * @return
     */
    @RequestMapping(value = "/defaultList",method = RequestMethod.GET)
    public String defaultList(@SearchParam BaseMaterialSearchCondition condition,ModelMap modelMap){
        condition.reset();//使页面上不显示当前session的数据
        this.commonList(condition,modelMap);
        return "baseMaterial/list";
    }

    /**
     * 查询
     * @param condition
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(
            @SearchParam BaseMaterialSearchCondition condition,
            ModelMap modelMap){
        this.commonList(condition,modelMap);
        return "baseMaterial/list";
    }

    private void commonList(BaseMaterialSearchCondition condition, ModelMap modelMap) {
        PageList<BaseMaterial> pageList = baseMaterialService.pageList(condition.getMaterialName(), condition.getClassCode(), new Page(condition.getPageNo(), Page.DefaultPageSize), 1);
        modelMap.addAttribute("list", pageList.getListData());
        modelMap.addAttribute("page", pageList.getPage());

        modelMap.addAttribute("condition", condition);
        modelMap.addAttribute("materialClasses", baseMaterialClassService.selectAllCodeAndName(1));
    }

    /**
     * 去新增
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(ModelMap modelMap){
        modelMap.addAttribute("materialClasses", baseMaterialClassService.selectAllCodeAndName(1));
        return "baseMaterial/addOrUpdate";
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
            ModelMap modelMap){
        BaseMaterial baseMaterial = baseMaterialService.selectById(materialId);
        MyObjectNullException.checkNull(baseMaterial,logger,"主键是"+materialId+"的对象不存在");
        modelMap.addAttribute("baseMaterial", baseMaterial);
        modelMap.addAttribute("materialClasses", baseMaterialClassService.selectAllCodeAndName(1));
        return "baseMaterial/addOrUpdate";
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

    public static  class BaseMaterialSearchCondition {
        private String materialName;
        private String classCode;
        private Integer pageNo = 1;

        public BaseMaterialSearchCondition() {
        }

        public BaseMaterialSearchCondition(String materialName, String classCode, Integer pageNo) {
            this.materialName = materialName;
            this.classCode = classCode;
            this.pageNo = pageNo;
        }

        public void reset(){
            setMaterialName(null);
            setClassCode(null);
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public String getClassCode() {
            return classCode;
        }

        public void setClassCode(String classCode) {
            this.classCode = classCode;
        }

        public Integer getPageNo() {
            return pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }
    }

}

