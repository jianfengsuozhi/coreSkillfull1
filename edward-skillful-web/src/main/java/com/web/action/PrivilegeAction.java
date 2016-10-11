package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.PrivilegeService;
import com.exception.MyException;
import com.provider.model.Privilege;
import com.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Edward on 2016/10/7.
 */
@Controller
@RequestMapping("/privilege")
@PreAuthorize("hasAnyRole('6')") //这样做的目的：访问/privilege/** 的url必须拥有这个权限
public class PrivilegeAction {
    private Logger logger = LoggerFactory.getLogger(PrivilegeAction.class);

    @Resource
    private PrivilegeService privilegeService;

    /**
     * 列举
     * @param pageNo
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
            ModelMap modelMap){
        PageList<Privilege> pageList = privilegeService.selectPageList(new Page(pageNo, Page.DefaultPageSize));
        modelMap.addAttribute("list", pageList.getListData());
        modelMap.addAttribute("page", pageList.getPage());
        return "privilege/list";
    }

    /**
     * 去新增或修改
     * @param privilegeId
     * @param modelMap
     * @return
     */
    @PreAuthorize("hasAnyRole('7') or hasAnyRole('8')")
    @RequestMapping(value = "/toSave",method = RequestMethod.GET)
    public String toSave(
            @RequestParam(value = "privilegeId",required = false)Integer privilegeId,
            ModelMap modelMap){
        if(null != privilegeId){
            modelMap.addAttribute("privilege", privilegeService.selectById(privilegeId));
        }
        return "privilege/save";
    }

    /**
     * 插入或保存
     * @param privilege
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('7') or hasAnyRole('8')")
    public JsonData save(@ModelAttribute Privilege privilege){
        try {
            privilegeService.save(privilege);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed();
    }

    /**
     * 删除
     * @param privilegeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('9')")
    public JsonData delete(
            @RequestParam(value = "privilegeId",required = true)Integer privilegeId){
        try {
            privilegeService.deletePhy(privilegeId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed();
    }

    /**
     * 查看
     * @param privilegeId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "privilegeId",required = true)Integer privilegeId,ModelMap modelMap){
        modelMap.addAttribute("privilege", privilegeService.selectById(privilegeId));
        return "privilege/view";
    }

}
