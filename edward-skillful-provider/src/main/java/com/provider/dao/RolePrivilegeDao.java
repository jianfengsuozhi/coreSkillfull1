package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.RolePrivilege;
import com.provider.model.RolePrivilegeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePrivilegeDao extends SingleTableDao<RolePrivilege, RolePrivilegeCriteria> {
}