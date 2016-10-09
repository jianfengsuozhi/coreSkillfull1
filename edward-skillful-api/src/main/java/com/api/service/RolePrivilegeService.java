package com.api.service;

import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseService;
import com.exception.MyException;
import com.provider.model.RolePrivilege;

import java.util.List;

public interface RolePrivilegeService extends AbstractBaseService<RolePrivilege> {
    /**
     * 查询
     * @param roleId
     * @return
     */
    List<CodeAndName> selectPrivilegeCodesByRoleId(Integer roleId);

    /**
     * 删除
     * @param roleId
     */
    void delete(Integer roleId);

    /**
     * 保存
     * @param privilageCodes
     * @param roleId
     */
    void save(List<String> privilageCodes,Integer roleId) throws MyException;
}