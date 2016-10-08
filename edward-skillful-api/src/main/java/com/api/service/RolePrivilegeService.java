package com.api.service;

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
    List<String> selectPrivilegeCodesByRoleId(Integer roleId);

    /**
     * 保存
     * @param rolePrivilege
     */
    void save(RolePrivilege rolePrivilege) throws MyException;

    /**
     * 删除
     * @param roleId
     */
    void delete(Integer roleId);
}