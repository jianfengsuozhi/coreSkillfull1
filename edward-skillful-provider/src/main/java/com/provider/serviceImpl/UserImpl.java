package com.provider.serviceImpl;

import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.UserService;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.provider.dao.UserDao;
import com.provider.model.User;
import com.provider.model.UserCriteria;
import com.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserImpl extends AbstractBaseServiceImpl<User, UserCriteria> implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public SingleTableDao<User, UserCriteria> getMyBatisRepository() {
        return userDao;
    }

    @Override
    public PageList<User> pageList(Page page) {
        UserCriteria criteria = new UserCriteria();
        return queryPageList(criteria, page, "user_name");
    }

    @Override
    public void save(User user) throws MyException {
        MyIllegalArgumentException.checkNull(user,logger,"user对象不能为null");
        if(null == user.getUserId()){
            user.setCreateTime(DateUtils.getCurDate());
            user.setModifyTime(DateUtils.getCurDate());

            this.insert(user);
        }else {
            user.setModifyTime(DateUtils.getCurDate());
            User oldUser = this.selectById(user.getUserId());
            user.setCreateTime(oldUser.getCreateTime());

            this.updateById(user);
        }
    }
}