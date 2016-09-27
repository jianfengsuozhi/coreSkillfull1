package com.api.service;

import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.BaseMaterial;

public interface BaseMaterialService extends AbstractBaseService<BaseMaterial> {
    /**
     * 分页
     * @param materialName 物资名称和编码 可选
     * @param classCode 可选
     * @param page
     * @return
     */
    PageList<BaseMaterial> pageList(String materialName,String classCode,Page page,Integer parentHospitalId);

    /**
     * 新增和修改
     * @param baseMaterial
     */
    public void save(BaseMaterial baseMaterial) throws MyException;

    /**
     * 删除
     * @param materialId
     * @throws MyException
     */
    public void delete(Integer materialId) throws MyException;
}