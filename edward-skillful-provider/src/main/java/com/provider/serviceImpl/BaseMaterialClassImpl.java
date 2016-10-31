package com.provider.serviceImpl;

import com.api.modelEx.CodeAndName;
import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.BaseMaterialClassService;
import com.enums.MyEnums;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.exception.MyObjectNullException;
import com.google.common.collect.Lists;
import com.provider.dao.BaseMaterialClassDao;
import com.provider.model.BaseMaterialClass;
import com.provider.model.BaseMaterialClassCriteria;
import com.redis.RedisUtils01;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaseMaterialClassImpl extends AbstractBaseServiceImpl<BaseMaterialClass, BaseMaterialClassCriteria> implements BaseMaterialClassService {
    private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);
    @Resource
    private BaseMaterialClassDao baseMaterialClassDao;
    @Resource
    private RedisUtils01 redisUtils;

    @Override
    public SingleTableDao<BaseMaterialClass, BaseMaterialClassCriteria> getMyBatisRepository() {
        return baseMaterialClassDao;
    }

    @Override
    public PageList<BaseMaterialClass> pageList(String className, Page page) {
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        BaseMaterialClassCriteria.Criteria innerCriteria = criteria.or().andClassStatusNotEqualTo(MyEnums.Status.Delete.getCode());
        if(StringUtils.isNotBlank(className)){
            innerCriteria.andClassNameLikeInsensitive("%"+className.trim()+"%");
        }
        return this.queryPageList(criteria,page,"order_no,class_name");
    }

    @Override
    public List<BaseMaterialClass> selectAll() {
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        criteria.or().andClassStatusNotEqualTo(MyEnums.Status.Delete.getCode());
        return baseMaterialClassDao.selectByCriteria(criteria);
    }

    @Override
    public void save(BaseMaterialClass baseMaterialClass) throws MyException {
        MyIllegalArgumentException.checkNull(baseMaterialClass,logger,"baseMaterialClass不能为null");
        //修改
        if (null != baseMaterialClass.getClassId()){
            BaseMaterialClass updateFinalEntity = this.getUpdateFinalEntity(baseMaterialClass);
            //判断名字是否唯一 注意:修改时parentHospitalId从以前的记录获得
            Boolean nameIsUnique = this.nameIsUnique(updateFinalEntity.getClassId(), updateFinalEntity.getClassName(), updateFinalEntity.getParentHospitalId());
            if(!nameIsUnique){
                throw new MyException("名字不唯一");
            }
            this.updateById(updateFinalEntity);
        }else { //新增
            this.setInsertColumnValue(baseMaterialClass);
            Boolean nameIsUnique = this.nameIsUnique(baseMaterialClass.getClassId(), baseMaterialClass.getClassName(), baseMaterialClass.getParentHospitalId());
            if(!nameIsUnique){
                throw new MyException("名字不唯一");
            }
            this.insert(baseMaterialClass);
        }
    }

    /**
     * 得到最终修改时的值
     * @param baseMaterialClass
     * @return
     */
    private BaseMaterialClass getUpdateFinalEntity(BaseMaterialClass baseMaterialClass) {
        BaseMaterialClass finalMaterialClass = selectById(baseMaterialClass.getClassId());
        this.setUpdateColumnValue(baseMaterialClass,finalMaterialClass);
        return finalMaterialClass;
    }

    /**
     * 设置更新时字段值
     * @param baseMaterialClass
     * @param finalMaterialClass
     */
    private void setUpdateColumnValue(BaseMaterialClass baseMaterialClass,BaseMaterialClass finalMaterialClass){
        //前台传过来的值
        finalMaterialClass.setClassCode(baseMaterialClass.getClassCode());
        finalMaterialClass.setClassName(baseMaterialClass.getClassName());
        finalMaterialClass.setOrderNo(baseMaterialClass.getOrderNo());
        //变化值
        finalMaterialClass.setModifyTime(DateTime.now().toDate());
    }

    /**
     * 设置插入值
     * @param baseMaterialClass
     */
    private void setInsertColumnValue(BaseMaterialClass baseMaterialClass){
        if (null == baseMaterialClass.getOrderNo()){
            baseMaterialClass.setOrderNo(1);
        }
        baseMaterialClass.setClassStatus(MyEnums.Status.Normal.getCode());
        baseMaterialClass.setParentClassCode("1");
        baseMaterialClass.setCreateTime(DateTime.now().toDate());
        baseMaterialClass.setModifyTime(DateTime.now().toDate());
    }

    @Override
    public void delete(Integer classId) throws MyException {
        BaseMaterialClass baseMaterialClass = selectById(classId);
        MyObjectNullException.checkNull(baseMaterialClass,logger,"主键为"+classId+"物资分类不存在");
        baseMaterialClass.setClassStatus(MyEnums.Status.Delete.getCode());
        this.updateById(baseMaterialClass);
    }

    /**
     * 判断名字是否唯一
     * @param classId
     * @param className
     * @param parentHospitalId
     * @return
     */
    private Boolean nameIsUnique(Integer classId,String className,Integer parentHospitalId){
        BaseMaterialClass baseMaterialClass = this.selectByName(className, parentHospitalId);
        //名字唯一:插入时baseMaterialClass,修改时返回值id和classId相同
        if(null== baseMaterialClass|| null != baseMaterialClass && baseMaterialClass.getClassId().equals(classId)){
            return true;
        }
        return false;
    }

    private BaseMaterialClass selectByName(String className,Integer parentHospitalId ){
        MyIllegalArgumentException.checkTrue(StringUtils.isBlank(className),logger,"className不能为空");
        MyIllegalArgumentException.checkNull(parentHospitalId,logger,"parentHospitalId不能为null");
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        criteria.or().andClassNameLikeInsensitive(className).andParentHospitalIdEqualTo(parentHospitalId).andClassStatusNotEqualTo(MyEnums.Status.Delete.getCode());
        return queryEntity(criteria);
    }

    @Override
    public String getClassNameByClassCode(String classCode) {
        MyIllegalArgumentException.checkTrue(StringUtils.isBlank(classCode),logger,"classCode不能为空");
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        criteria.or().andClassCodeEqualTo(classCode);
        BaseMaterialClass baseMaterialClass = this.queryEntity(criteria);
        MyObjectNullException.checkNull(baseMaterialClass,logger,"classCode:"+classCode+"的物资分类对象不能为null");
        return baseMaterialClass.getClassName();
    }

    @Override
    public List<CodeAndName> selectAllCodeAndName(Integer parentHospitalId) {
        String cacheKey = String.format("baseMaterialClass%s", parentHospitalId);
        if(redisUtils.exists(cacheKey)){
            return (List<CodeAndName>)redisUtils.get(cacheKey);
        }
        ArrayList<CodeAndName> lists = Lists.newArrayList();
        List<BaseMaterialClass> baseMaterialClasses = this.selectAll(parentHospitalId);
        for (BaseMaterialClass baseMaterialClass : baseMaterialClasses) {
            CodeAndName codeAndName = new CodeAndName(baseMaterialClass.getClassCode(), baseMaterialClass.getClassName());
            lists.add(codeAndName);
        }
        redisUtils.set(cacheKey,lists,null);
        return lists;
    }

    private List<BaseMaterialClass> selectAll(Integer parentHospitalId){
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        criteria.or().andParentHospitalIdEqualTo(parentHospitalId).andClassStatusNotEqualTo(MyEnums.Status.Delete.getCode());
        return baseMaterialClassDao.selectByCriteria(criteria);
    }
}