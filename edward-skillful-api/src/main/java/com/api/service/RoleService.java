package com.api.service;

import com.api.modelEx.IdAndName;
import com.api.modelEx.RoleEx;
import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.Role;

import java.util.List;

public interface RoleService extends AbstractBaseService<Role> {
    /**
     * 查询所有
     * @return
     */
    List<IdAndName> selectAllCodeAndName();

    /**
     * 分页查询
     * @param page
     * @return
     */
    PageList<Role> selectPageList(Page page);

    /**
     * 保存
     * @param roleEx
     */
    void save(RoleEx roleEx) throws MyException;

    /**
     * 删除
     * @param roleId
     */
    void delete(Integer roleId);

}