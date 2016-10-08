package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.Role;
import com.provider.model.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao extends SingleTableDao<Role, RoleCriteria> {
}