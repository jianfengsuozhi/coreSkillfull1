package com.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * 获取用户信息
 * Created by weideliang on 2016/9/30.
 */
public class MyUserDetailService  implements UserDetailsService{

    /*
    * 根据用户名获取用户详细信息
    * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
        GrantedAuthorityImpl role1 = new GrantedAuthorityImpl("ROLE_ADMIN");
        GrantedAuthorityImpl role2 = new GrantedAuthorityImpl("ROLE_USER");

        if("wdl".equals(username)){
            roles.add(role1);
            roles.add(role2);
        }

        User user = new User(username, "wdl", true, true, true, true, roles);
        return user;
    }
}
