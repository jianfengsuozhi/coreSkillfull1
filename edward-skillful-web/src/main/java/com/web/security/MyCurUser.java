package com.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by weideliang on 2016/10/10.
 */
public class MyCurUser extends User {
    private com.provider.model.User user;

    public MyCurUser(String username, String password, Collection<? extends GrantedAuthority> authorities, com.provider.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public MyCurUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, com.provider.model.User user) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public com.provider.model.User getUser() {
        return user;
    }

    public void setUser(com.provider.model.User user) {
        this.user = user;
    }
}
