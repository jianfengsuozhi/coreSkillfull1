package com.api.service;

import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyBusinessException;
import com.provider.model.BaseMaterialClass;

import java.util.List;

public interface BaseMaterialClassService extends AbstractBaseService<BaseMaterialClass>{
    /**
     * 分页
     * @param className
     * @param page
     * @return
     */
    PageList<BaseMaterialClass> pageList(String className, Page page);
}