package com.api.page;

import com.exception.MyException;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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

    public PageList<U> queryPageList(V queryObject, Page page) {
        Preconditions.checkNotNull(queryObject, "queryObject不能为null");
        int count = new Long(getMyBatisRepository().countByCriteria(queryObject)).intValue();
        page.setTotalRecords(count);
        if (0 == count) {
            return PageList.getPageList(new ArrayList<U>(), page);
        }
        return PageList.getPageList(getMyBatisRepository().
                selectByCriteria(queryObject), page);
    }


}
