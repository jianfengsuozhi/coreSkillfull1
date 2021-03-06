package com.provider.serviceImpl;

import com.api.cache.CacheInfo;
import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.PrivilegeService;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.google.common.collect.Lists;
import com.provider.dao.PrivilegeDao;
import com.provider.model.Privilege;
import com.provider.model.PrivilegeCriteria;
import com.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class PrivilegeImpl extends AbstractBaseServiceImpl<Privilege, PrivilegeCriteria> implements PrivilegeService {
    private Logger logger = LoggerFactory.getLogger(PrivilegeImpl.class);

    @Resource
    private PrivilegeDao privilegeDao;

    @Override
    public SingleTableDao<Privilege, PrivilegeCriteria> getMyBatisRepository() {
        return privilegeDao;
    }

    @Override
    public PageList<Privilege> selectPageList(Page page) {
        PrivilegeCriteria criteria = new PrivilegeCriteria();
        return this.queryPageList(criteria, page, "privilege_code");
    }

    @Override
    public void save(Privilege privilege) throws MyException {
        MyIllegalArgumentException.checkNull(privilege,logger,"privilege对象不能为null");
        if(null == privilege.getPrivilegeId()){
            privilege.setCreateTime(DateUtils.now());
            privilege.setModifyTime(DateUtils.now());
            this.insert(privilege);
        }else{
            privilege.setModifyTime(DateUtils.now());
            Privilege oldPrivilege = this.selectById(privilege.getPrivilegeId());
            privilege.setCreateTime(oldPrivilege.getCreateTime());

            this.updateById(privilege);
        }
    }

    @Override
    public List<CodeAndName> selectCodeAndNames() {
        List<Privilege> privileges = this.selectAll();

        LinkedList<CodeAndName> codeAndNames = Lists.newLinkedList();
        for (Privilege privilege : privileges) {
            codeAndNames.add(new CodeAndName(privilege.getPrivilegeCode(), privilege.getPrivilegeName()));
        }
        return codeAndNames;
    }

    @Override
    @Cacheable(CacheInfo.PrivilegeCodesKey)//同自己写的
    public List<Privilege> selectAll() {
        PrivilegeCriteria criteria = new PrivilegeCriteria();
        return privilegeDao.selectByCriteria(criteria);
    }
}