package com.provider.serviceImpl;

import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseServiceImpl;
import com.api.page.SingleTableDao;
import com.api.service.RolePrivilegeService;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.exception.MyObjectNullException;
import com.google.common.collect.Lists;
import com.provider.dao.RolePrivilegeDao;
import com.provider.model.RolePrivilege;
import com.provider.model.RolePrivilegeCriteria;
import com.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

import static javafx.scene.input.KeyCode.M;
import static javafx.scene.input.KeyCode.R;

@Service
public class RolePrivilegeImpl extends AbstractBaseServiceImpl<RolePrivilege, RolePrivilegeCriteria> implements RolePrivilegeService {
    private Logger logger = LoggerFactory.getLogger(RolePrivilegeImpl.class);
    @Resource
    private RolePrivilegeDao rolePrivilegeDao;

    @Override
    public SingleTableDao<RolePrivilege, RolePrivilegeCriteria> getMyBatisRepository() {
        return rolePrivilegeDao;
    }

    @Override
    public List<CodeAndName> selectPrivilegeCodesByRoleId(Integer roleId) {
        MyIllegalArgumentException.checkNull(roleId,logger,"userId不能为null");
        return rolePrivilegeDao.selectPrivilegeCodeAndNamesByUserId(roleId);
    }

    @Override
    public void delete(Integer roleId) {
        MyIllegalArgumentException.checkNull(roleId,logger,"roleId不能为null");
        RolePrivilegeCriteria criteria = new RolePrivilegeCriteria();
        criteria.or().andRoleIdEqualTo(roleId);
        rolePrivilegeDao.deleteByCriteria(criteria);
    }

    private void save(RolePrivilege rolePrivilege) throws MyException {
        MyIllegalArgumentException.checkNull(rolePrivilege,logger,"rolePrivilege对象不能为null");
        if(null == rolePrivilege.getRecordId()){
            rolePrivilege.setCreateTime(DateUtils.now());
            rolePrivilege.setModifyTime(DateUtils.now());
            this.insert(rolePrivilege);
        }else {
            rolePrivilege.setModifyTime(DateUtils.now());
            RolePrivilege oldRolePrivilege = this.selectById(rolePrivilege.getRecordId());
            MyObjectNullException.checkNull(oldRolePrivilege,logger,"主键是:"+rolePrivilege.getRecordId()+"的对象不能为null");
            rolePrivilege.setCreateTime(oldRolePrivilege.getCreateTime());
            this.updateById(rolePrivilege);
        }
    }

    @Override
    public void save(List<String> privilageCodes, Integer roleId) throws MyException {
        //先删除,在批量保存
        this.delete(roleId);
        //插入
        if(null == privilageCodes){
            return;
        }
        for (String privilageCode : privilageCodes) {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setRoleId(roleId);
            rolePrivilege.setPrivilegeCode(privilageCode);
            this.save(rolePrivilege);
        }
    }
}