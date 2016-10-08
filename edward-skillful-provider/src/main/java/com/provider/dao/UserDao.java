package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.User;
import com.provider.model.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends SingleTableDao<User, UserCriteria> {
}