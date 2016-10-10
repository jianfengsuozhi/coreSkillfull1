package com.web.security;

import com.api.modelEx.CodeAndName;
import com.api.service.RolePrivilegeService;
import com.api.service.UserService;
import com.google.common.collect.Lists;
import com.provider.serviceImpl.RolePrivilegeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获取用户信息
 * Created by weideliang on 2016/9/30.
 */
@Service("userDetailsService")
public class MyUserDetailService  implements UserDetailsService{
    private Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
    @Resource
    private UserService userService;
    @Resource
    private RolePrivilegeService rolePrivilegeService = new RolePrivilegeImpl();

    /*
    * 根据用户名获取用户详细信息
    * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用户
        com.provider.model.User user = userService.select(username);
        if(null == user){
            logger.error("用户名或密码错误");
            throw new AccessDeniedException("用户名或密码错误");
        }
        //权限
        List<CodeAndName> codeAndNames = rolePrivilegeService.selectPrivilegeCodesByRoleId(user.getRoleId());
        List<GrantedAuthority> privilageCodes = Lists.newArrayList();
        for (CodeAndName codeAndName : codeAndNames) {
            privilageCodes.add(new GrantedAuthorityImpl(codeAndName.getCode()));
        }
        return new MyCurUser(user.getUserName(), user.getPassword().toString(), true, true, true, true, privilageCodes, user);

//        ArrayList<GrantedAuthority> roles = new ArrayList<>();
//        GrantedAuthorityImpl role1 = new GrantedAuthorityImpl("ROLE_ADMIN");
//        GrantedAuthorityImpl role2 = new GrantedAuthorityImpl("ROLE_USER");
//
//        if("wdl".equals(username)){
//            roles.add(role1);
//            roles.add(role2);
//        }
//
//        User user = new User(username, "wdl", true, true, true, true, roles);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setRolePrivilegeService(RolePrivilegeService rolePrivilegeService) {
        this.rolePrivilegeService = rolePrivilegeService;
    }
}
