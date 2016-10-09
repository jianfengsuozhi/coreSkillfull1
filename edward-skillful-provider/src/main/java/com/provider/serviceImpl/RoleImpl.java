package com.provider.serviceImpl;

import com.api.modelEx.CodeAndName;
import com.api.modelEx.IdAndName;
import com.api.modelEx.RoleEx;
import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.RolePrivilegeService;
import com.api.service.RoleService;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.google.common.collect.Lists;
import com.provider.dao.RoleDao;
import com.provider.model.Role;
import com.provider.model.RoleCriteria;
import com.provider.model.RolePrivilege;
import com.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleImpl extends AbstractBaseServiceImpl<Role, RoleCriteria> implements RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleImpl.class);
    @Resource
    private RoleDao roleDao;
    @Resource
    private RolePrivilegeService rolePrivilegeService;

    @Override
    public SingleTableDao<Role, RoleCriteria> getMyBatisRepository() {
        return roleDao;
    }

    @Override
    public List<IdAndName> selectAllCodeAndName() {
        ArrayList<IdAndName> lists = Lists.newArrayList();
        List<Role> roles = this.selectAll();
        for (Role role : roles) {
            IdAndName idAndName = new IdAndName(role.getRoleId(), role.getRoleName());
            lists.add(idAndName);
        }
        return lists;
    }

    private List<Role> selectAll(){
        RoleCriteria criteria = new RoleCriteria();
        return roleDao.selectByCriteria(criteria);
    }

    /**
     * 分页
     * @param page
     * @return
     */
    @Override
    public PageList<Role> selectPageList(Page page) {
        RoleCriteria criteria = new RoleCriteria();
        return this.queryPageList(criteria, page, "role_name");
    }

    @Override
    public void save(RoleEx roleEx) throws MyException {
        MyIllegalArgumentException.checkNull(roleEx, logger,"roleEx对象不能为null");
        MyIllegalArgumentException.checkNull(roleEx.getRole(), logger,"role对象不能为null");
        Role role = roleEx.getRole();
        if(null == role.getRoleId()){
            //插入role
            this.insertRole(role);
            //插入role_Privilage
            rolePrivilegeService.save(roleEx.getPrivilageCodes(),role.getRoleId());
        }else{
            //修改
            Role oldRole = this.selectById(role.getRoleId());
            role.setCreateTime(oldRole.getCreateTime());
            role.setModifyTime(DateUtils.getCurDate());
            this.updateById(role);
            //插入role_Privilage：
            rolePrivilegeService.save(roleEx.getPrivilageCodes(),role.getRoleId());
        }
    }

    private void insertRole(Role role) throws MyException {
        role.setCreateTime(DateUtils.getCurDate());
        role.setModifyTime(DateUtils.getCurDate());
        this.insert(role);
    }

    @Override
    public void delete(Integer roleId) {
        this.deletePhy(roleId);
        rolePrivilegeService.delete(roleId);
    }
}