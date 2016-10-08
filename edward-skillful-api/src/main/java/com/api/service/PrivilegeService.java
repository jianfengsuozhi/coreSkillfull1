package com.api.service;

import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.Privilege;

import java.util.List;

public interface PrivilegeService extends AbstractBaseService<Privilege> {
    /**
     * 分页查询
     * @param page
     * @return
     */
    PageList<Privilege> selectPageList(Page page);

    /**
     * 保存
     * @param privilege
     * @throws MyException
     */
    void save(Privilege privilege) throws MyException;

    /**
     * 查询
     * @return
     */
    List<CodeAndName> selectCodeAndNames();
}