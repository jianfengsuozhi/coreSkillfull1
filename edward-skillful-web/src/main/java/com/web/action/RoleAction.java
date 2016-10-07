package com.web.action;

import com.api.modelEx.RoleEx;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.PrivilegeService;
import com.api.service.RolePrivilegeService;
import com.api.service.RoleService;
import com.exception.MyException;
import com.provider.model.Role;
import com.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Edward on 2016/10/7.
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
    private Logger logger = LoggerFactory.getLogger(RoleAction.class);

    @Resource
    private RoleService roleService;
    @Resource
    private RolePrivilegeService rolePrivilegeService;
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
        PageList<Role> pageList = roleService.selectPageList(new Page(pageNo, Page.DefaultPageSize));
        modelMap.addAttribute("list", pageList.getListData());
        modelMap.addAttribute("page", pageList.getPage());
        return "role/list";
    }

    /**
     * 去新增或去修改
     * @param roleId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/toSave",method = RequestMethod.GET)
    public String toSave(
            @RequestParam(value = "/roleId",required = false)Integer roleId,ModelMap modelMap){
        if(null != roleId){
            RoleEx roleEx = new RoleEx();
            roleEx.setRole(roleService.selectById(roleId));
            roleEx.setPrivilageCodes(rolePrivilegeService.selectPrivilegeCodesByRoleId(roleId));
            modelMap.addAttribute("roleEx", roleEx);
        }
        modelMap.addAttribute("codeAndNames", privilegeService.selectCodeAndNames());
        return "role/save";
    }

    /**
     * 保存
     * @param roleEx
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public JsonData save(
            @ModelAttribute RoleEx roleEx){
        try {
            roleService.save(roleEx);
        } catch (MyException e) {
            logger.error(e.getMessage());
            JsonData.getFailed("新增或保存失败");
        }
        return JsonData.getSucceed();
    }

    /**
     * 查看
     * @param roleId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "roleId",required = true)Integer roleId,ModelMap modelMap){
        modelMap.addAttribute("role", roleService.selectById(roleId));
        return "role/view";
    }

    /**
     * 删除
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public JsonData delete(
            @RequestParam(value = "roleId",required = true)Integer roleId){
        try {
            roleService.delete(roleId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonData.getFailed("删除失败");
        }
        return JsonData.getSucceed();
    }
}
