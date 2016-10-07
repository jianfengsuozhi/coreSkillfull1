package com.api.page;

import com.exception.MyException;
import com.exception.MyObjectMultiple;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weideliang on 2016/9/19.
 * 1 两者不是继承关系
 * 2 getPageList中的page有调用方传入
 * 3 注意实现类的作用域>=接口的作用域，否则该方法不是该接口的作用域
 */
public abstract class AbstractBaseServiceImpl<U, V extends PageCriteria> {
    private Logger logger = LoggerFactory.getLogger(AbstractBaseServiceImpl.class);

    protected abstract SingleTableDao<U, V> getMyBatisRepository();

    public U selectById(Integer id) {
        Preconditions.checkNotNull(id, "id不能为null");
        return getMyBatisRepository().selectById(id);
    }

    public void insert(U entity) throws MyException {
        Preconditions.checkNotNull(entity, "entity不能为null");
        int count = getMyBatisRepository().insert(entity);
        if (1 != count) {
            throw new MyException("数据库插入失败");
        }
    }

    public void updateById(U entity) throws MyException {
        Preconditions.checkNotNull(entity, "entity不能为null");
        int count = getMyBatisRepository().updateById(entity);
        if (1 != count) {
            throw new MyException("数据库修改失败");
        }
    }

    public U queryEntity(V queryObject){
        Preconditions.checkNotNull(queryObject,"queryObject不能为null");
        List<U> list = getMyBatisRepository().selectByCriteria(queryObject);
        if(0 == list.size()){//集合是判断size()与0的关系，不是判断与null关系
            return null;
        }else if(1 == list.size()){
            return list.get(0);
        }else{
            throw MyObjectMultiple.create(logger, "对象存在多个");
        }
    }

    public PageList<U> queryPageList(V queryObject, Page page,String orderByClause) {
        Preconditions.checkNotNull(queryObject, "queryObject不能为null");
        int count = getMyBatisRepository().countByCriteria(queryObject);
        page.setTotalRecords(count);
        if (0 == count) {
            return PageList.getPageList(new ArrayList<U>(), page);
        }
        //分页
        queryObject.setPage(page);
        //排序
        queryObject.setOrderByClause(orderByClause);
        return PageList.getPageList(getMyBatisRepository().
                selectByCriteria(queryObject), page);
    }

    public void deletePhy(Integer recordId){
        Preconditions.checkNotNull(recordId, "recordId不能为null");
        int count = getMyBatisRepository().deleteById(recordId);
        if(1 != count){
            throw MyObjectMultiple.create(logger, "数据库删除失败");
        }
    }


}
