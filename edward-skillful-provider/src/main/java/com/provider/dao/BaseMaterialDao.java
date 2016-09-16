package com.provider.dao;

import com.provider.model.BaseMaterial;
import com.provider.model.BaseMaterialCriteria;
import com.provider.page.SingleTableDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMaterialDao extends SingleTableDao<BaseMaterial, BaseMaterialCriteria> {
}