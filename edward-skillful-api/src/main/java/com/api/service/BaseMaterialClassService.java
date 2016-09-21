package com.api.service;

import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.BaseMaterialClass;

public interface BaseMaterialClassService extends AbstractBaseService<BaseMaterialClass> {
    /**
     * 分页
     * @param className
     * @param page
     * @return
     */
    PageList<BaseMaterialClass> pageList(String className, Page page);


    /**
     * 新增或修改
     * @param baseMaterialClass
     */
    void save(BaseMaterialClass baseMaterialClass) throws MyException;

    /**
     * 删除
     * @param classId
     * @throws MyException
     */
    void delete(Integer classId) throws MyException;
}