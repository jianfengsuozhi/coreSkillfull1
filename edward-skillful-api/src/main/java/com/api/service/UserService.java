package com.api.service;

import com.api.page.AbstractBaseService;
import com.api.page.Page;
import com.api.page.PageList;
import com.exception.MyException;
import com.provider.model.User;

public interface UserService extends AbstractBaseService<User> {
    /**
     * 查询
     * @param page
     * @return
     */
    PageList<User> pageList(Page page);

    /**
     * 查询
     * @param userName
     * @return
     */
    User select(String userName);

    /**
     * 保存
     * @param user
     */
    void save(User user) throws MyException;
}