package com.provider.serviceImpl;

import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.BaseMaterialClassService;
import com.enums.MyInterfaceEnum;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.exception.MyObjectNullException;
import com.provider.dao.BaseMaterialClassDao;
import com.provider.model.BaseMaterialClass;
import com.provider.model.BaseMaterialClassCriteria;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Resource
public class BaseMaterialClassImpl extends AbstractBaseServiceImpl<BaseMaterialClass, BaseMaterialClassCriteria> implements BaseMaterialClassService {
    private Logger logger = LoggerFactory.getLogger(BaseMaterialClassImpl.class);
    @Resource
    private BaseMaterialClassDao baseMaterialClassDao;

    @Override
    public SingleTableDao<BaseMaterialClass, BaseMaterialClassCriteria> getMyBatisRepository() {
        return baseMaterialClassDao;
    }

    @Override
    public PageList<BaseMaterialClass> pageList(String className, Page page) {
        BaseMaterialClassCriteria criteria = new BaseMaterialClassCriteria();
        BaseMaterialClassCriteria.Criteria innerCriteria = criteria.or();
        if(StringUtils.isNotBlank(className)){
            innerCriteria.andClassNameLikeInsensitive("%"+className.trim()+"%");
        }
        criteria.setOrderByClause("order_no,class_name");
        criteria.setPage(page);
        return this.queryPageList(criteria,page);
    }

    @Override
    public void save(BaseMaterialClass baseMaterialClass) throws MyException {
        MyIllegalArgumentException.checkNull(baseMaterialClass,logger,"baseMaterialClass不能为null");
        MyIllegalArgumentException.checkNull(baseMaterialClass.getParentHospitalId(),logger,"parentHospitalId不能为null");
        if (null == baseMaterialClass.getClassId()){
            BaseMaterialClass updateFinalEntity = this.getUpdateFinalEntity(baseMaterialClass);
            this.updateById(updateFinalEntity);
        }else {
            this.setInsertColumnValue(baseMaterialClass);
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
        baseMaterialClass.setClassStatus(MyInterfaceEnum.Status.Normal.getCode());
        baseMaterialClass.setParentClassCode("1");
        baseMaterialClass.setCreateTime(DateTime.now().toDate());
        baseMaterialClass.setModifyTime(DateTime.now().toDate());
    }

    @Override
    public void delete(Integer classId) throws MyException {
        BaseMaterialClass baseMaterialClass = selectById(classId);
        MyObjectNullException.checkNull(baseMaterialClass,logger,"主键为"+classId+"物资分类不存在");
        baseMaterialClass.setClassStatus(MyInterfaceEnum.Status.Delete.getCode());
        this.updateById(baseMaterialClass);
    }
}