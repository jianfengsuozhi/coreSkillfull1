package com.provider.serviceImpl;

import com.api.page.AbstractBaseServiceImpl;
import com.api.page.SingleTableDao;
import com.api.service.BaseMaterialService;
import com.provider.dao.BaseMaterialDao;
import com.provider.model.BaseMaterial;
import com.provider.model.BaseMaterialCriteria;
import javax.annotation.Resource;

@Resource
public class BaseMaterialImpl extends AbstractBaseServiceImpl<BaseMaterial, BaseMaterialCriteria> implements BaseMaterialService {
    @Resource
    private BaseMaterialDao baseMaterialDao;

    @Override
    public SingleTableDao<BaseMaterial, BaseMaterialCriteria> getMyBatisRepository() {
        return baseMaterialDao;
    }
}