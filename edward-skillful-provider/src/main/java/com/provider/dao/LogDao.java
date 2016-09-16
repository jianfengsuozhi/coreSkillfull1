package com.provider.dao;

import com.provider.model.Log;
import com.provider.model.LogCriteria;
import com.provider.page.SingleTableDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogDao extends SingleTableDao<Log, LogCriteria> {
}