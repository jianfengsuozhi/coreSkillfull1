package com.web.action;

import com.api.page.Page;
import com.api.page.PageList;
import com.api.service.RoleService;
import com.api.service.UserService;
import com.exception.MyException;
import com.provider.model.User;
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
@RequestMapping("/user")
public class UserAction {
    private Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    /**
     * 列表
     * @param pageNo
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(
            @RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
            ModelMap modelMap){
        PageList<User> pageList = userService.pageList(new Page(pageNo, Page.DefaultPageSize));
        modelMap.addAttribute("list", pageList.getListData());
        modelMap.addAttribute("page", pageList.getPage());
        return "user/list";
    }

    /**
     * 去新增或修改
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String toSave(
            @RequestParam(value = "userId",required = false)Integer userId,
            ModelMap modelMap){
        if(null != userId){
            User user = userService.selectById(userId);
            modelMap.addAttribute("user", user);
        }
        modelMap.addAttribute("roles", roleService.selectAllCodeAndName());
        return "user/save";
    }

    /**
     * 保存或更新
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public JsonData save(@ModelAttribute User user){
        try {
            userService.save(user);
        } catch (MyException e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed();
    }

    /**
     * 查看
     * @param userId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "userId",required = true)Integer userId,
            ModelMap modelMap){
        User user = userService.selectById(userId);
        modelMap.addAttribute("user", user);
        return "user/view";
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public JsonData delete(
            @RequestParam(value = "userId",required = true)Integer userId){
        try {
            userService.deletePhy(userId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return JsonData.getFailed(e.getMessage());
        }
        return JsonData.getSucceed();
    }
}


