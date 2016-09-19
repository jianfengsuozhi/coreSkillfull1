package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.BaseMaterialClass;
import com.provider.model.BaseMaterialClassCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMaterialClassDao extends SingleTableDao<BaseMaterialClass, BaseMaterialClassCriteria> {
}