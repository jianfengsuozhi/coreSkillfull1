package com.api.page;

import com.exception.MyException;

/**
 * 公有类
 */
public interface AbstractBaseService<U> {
    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    U selectById(Integer id);

    /**
     * 插入
     *
     * @param entity
     * @throws MyException
     */
//    void insert(U entity) throws MyException;

    /**
     * 根据主键id修改
     *
     * @param entity
     * @throws MyException
     */
//    void updateById(U entity) throws MyException;

    /**
     * 分页查询
     *
     * @param queryObject
     * @param page
     * @return
     */
//    PageList<U> queryPageList(V queryObject, Page page);
}
