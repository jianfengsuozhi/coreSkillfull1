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

    /**
     * 查询实体 如名字唯一
      * @param queryObject
     * @return
     */
//    U queryEntity(V queryObject);

    /**
     * 物理删除
     * @param recordId
     */
    void deletePhy(Integer recordId);
}
