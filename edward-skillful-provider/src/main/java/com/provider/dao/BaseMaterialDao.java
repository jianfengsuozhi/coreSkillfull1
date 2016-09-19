package com.provider.dao;

import com.api.page.SingleTableDao;
import com.provider.model.BaseMaterial;
import com.provider.model.BaseMaterialCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMaterialDao extends SingleTableDao<BaseMaterial, BaseMaterialCriteria> {
}