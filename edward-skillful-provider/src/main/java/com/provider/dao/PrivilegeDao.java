package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.Privilege;
import com.provider.model.PrivilegeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeDao extends SingleTableDao<Privilege, PrivilegeCriteria> {
}