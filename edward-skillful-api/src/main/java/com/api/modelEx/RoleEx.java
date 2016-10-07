package com.api.modelEx;

import com.provider.model.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Edward on 2016/10/7.
 */
public class RoleEx  implements Serializable{
    private Role role;
    private List<String> privilageCodes;

    public List<String> getPrivilageCodes() {
        return privilageCodes;
    }

    public void setPrivilageCodes(List<String> privilageCodes) {
        this.privilageCodes = privilageCodes;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
