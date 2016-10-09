package com.provider.dao;

import com.api.modelEx.CodeAndName;
import com.api.page.SingleTableDao;
import com.provider.model.RolePrivilege;
import com.provider.model.RolePrivilegeCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePrivilegeDao extends SingleTableDao<RolePrivilege, RolePrivilegeCriteria> {
    /**
     * 根据用户id获取权限编码和权限名称
     * @param userId
     * @return
     */
    List<CodeAndName> selectPrivilegeCodeAndNamesByUserId(@Param("userId")Integer userId);
}