package com.api.service;

import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.BaseMaterialClass;

import java.util.List;

public interface BaseMaterialClassService extends AbstractBaseService<BaseMaterialClass> {
    /**
     * 分页
     * @param className 可选
     * @param page
     * @return
     */
    PageList<BaseMaterialClass> pageList(String className, Page page);

    /**
     * 根据物资编码得到物资名称
     * @param classCode
     * @return
     */
    String getClassNameByClassCode(String classCode);

    /**
     * 所有物资分类
     * @param parentHospitalId
     * @return
     */
     List<CodeAndName> selectAllCodeAndName(Integer parentHospitalId);

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