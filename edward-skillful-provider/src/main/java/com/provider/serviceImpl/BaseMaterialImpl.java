package com.provider.serviceImpl;

import com.api.page.AbstractBaseServiceImpl;
import com.api.page.Page;
import com.api.page.PageList;
import com.api.page.SingleTableDao;
import com.api.service.BaseMaterialClassService;
import com.api.service.BaseMaterialService;
import com.enums.MyEnums;
import com.exception.MyException;
import com.exception.MyIllegalArgumentException;
import com.provider.dao.BaseMaterialDao;
import com.provider.model.BaseMaterial;
import com.provider.model.BaseMaterialClass;
import com.provider.model.BaseMaterialCriteria;
import com.utils.DateUtils;
import com.utils.PingYinUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BaseMaterialImpl extends AbstractBaseServiceImpl<BaseMaterial, BaseMaterialCriteria> implements BaseMaterialService {
    private Logger logger = LoggerFactory.getLogger(BaseMaterialImpl.class);
    @Resource
    private BaseMaterialClassService baseMaterialClassService;
    @Resource
    private BaseMaterialDao baseMaterialDao;

    @Override
    public SingleTableDao<BaseMaterial, BaseMaterialCriteria> getMyBatisRepository() {
        return baseMaterialDao;
    }

    @Override
    public PageList<BaseMaterial> pageList(String materialName, String classCode, Page page, Integer parentHospitalId) {
        MyIllegalArgumentException.checkNull(page,logger,"分页不能为null");
        MyIllegalArgumentException.checkNull(parentHospitalId,logger,"parentHospitalId不能为null");

        BaseMaterialCriteria criteria = new BaseMaterialCriteria();
        BaseMaterialCriteria.Criteria innerCriteria1 = criteria.or().andStatusNotEqualTo(MyEnums.Status.Delete.getCode()).
                andParentHospitalIdEqualTo(parentHospitalId);
        BaseMaterialCriteria.Criteria innerCriteria2 = criteria.or().andStatusNotEqualTo(MyEnums.Status.Delete.getCode()).
                andParentHospitalIdEqualTo(parentHospitalId);
        if(StringUtils.isNotBlank(materialName)){
            innerCriteria1.andMaterialNameLikeInsensitive("%" + materialName.trim() + "%");
            innerCriteria2.andMaterialCodeEqualTo(materialName);
        }
        if(StringUtils.isNotBlank(classCode)){
            innerCriteria1.andClassCodeEqualTo(classCode);
            innerCriteria2.andClassCodeEqualTo(classCode);
        }
        return this.queryPageList(criteria,page,"material_code");
    }

    @Override
    public void save(BaseMaterial baseMaterial) throws MyException {
        MyIllegalArgumentException.checkNull(baseMaterial,logger,"baseMaterial不能为null");
        //修改
        if (null != baseMaterial.getMaterialId()){
            BaseMaterial updateFinalEntity = this.getUpdateFinalEntity(baseMaterial);
            //判断名字是否唯一 注意:修改时parentHospitalId从以前的记录获得
            Boolean nameIsUnique = this.nameIsUnique(updateFinalEntity.getMaterialId(), updateFinalEntity.getMaterialName(), updateFinalEntity.getParentHospitalId());
            if(!nameIsUnique){
                throw new MyException("名字不唯一");
            }
            this.updateById(updateFinalEntity);
        }else { //新增
            this.setInsertColumnValue(baseMaterial);
            Boolean nameIsUnique = this.nameIsUnique(baseMaterial.getMaterialId(), baseMaterial.getMaterialName(), baseMaterial.getParentHospitalId());
            if(!nameIsUnique){
                throw new MyException("名字不唯一");
            }
            this.insert(baseMaterial);
        }
    }

    /**
     * 得到最终修改时的值
     * @param baseMaterial
     * @return
     */
    private BaseMaterial getUpdateFinalEntity(BaseMaterial baseMaterial) {
        BaseMaterial finalMaterial = selectById(baseMaterial.getMaterialId());
        this.setUpdateColumnValue(baseMaterial,finalMaterial);
        return finalMaterial;
    }

    /**
     * 设置更新时字段值
     * @param baseMaterial
     * @param finalMaterial
     */
    private void setUpdateColumnValue(BaseMaterial baseMaterial,BaseMaterial finalMaterial){
        //前台传过来的值
        finalMaterial.setOrderNo(null == baseMaterial.getOrderNo() ? 1 : baseMaterial.getOrderNo());//有值就取折个值,无值默认为1
        finalMaterial.setMaterialCode(baseMaterial.getMaterialCode());
        finalMaterial.setMaterialName(baseMaterial.getMaterialName());
        finalMaterial.setMaterialSpec(baseMaterial.getMaterialSpec());
        //若助记码有值则取这个值,若无值,则取物资名称拼音的首字母
        String mnemonicCode = null == baseMaterial.getMnemonicCode() ? PingYinUtil.getFirstSpell(baseMaterial.getMaterialName()) : baseMaterial.getMnemonicCode();
        finalMaterial.setMnemonicCode(mnemonicCode);
        finalMaterial.setMaterialUnit(baseMaterial.getMaterialUnit());
        finalMaterial.setClassCode(baseMaterial.getClassCode());
        finalMaterial.setClassName(baseMaterialClassService.getClassNameByClassCode(baseMaterial.getClassCode()));
        finalMaterial.setPlantingSysCode(baseMaterial.getPlantingSysCode());//ToDO
        finalMaterial.setPlantingSysName(baseMaterial.getPlantingSysName());//ToDO
        //变化值
        finalMaterial.setModifyTime(DateUtils.getCurDate());
        finalMaterial.setCode(baseMaterial.getMaterialCode());
    }

    /**
     * 设置插入值
     * @param baseMaterial
     */
    private void setInsertColumnValue(BaseMaterial baseMaterial){
        if (null == baseMaterial.getOrderNo()){
            baseMaterial.setOrderNo(1);
        }
        if(null == baseMaterial.getMnemonicCode()){
            baseMaterial.setMnemonicCode(PingYinUtil.getFirstSpell(baseMaterial.getMaterialName()));
        }
        baseMaterial.setClassName(baseMaterialClassService.getClassNameByClassCode(baseMaterial.getClassCode()));
        baseMaterial.setStatus(MyEnums.Status.Normal.getCode());
        baseMaterial.setCreateTime(DateUtils.getCurDate());
        baseMaterial.setModifyTime(DateUtils.getCurDate());
        baseMaterial.setCode(baseMaterial.getMaterialCode());
    }

    /**
     * 判断名字是否唯一
     * @param materialId
     * @param materialName
     * @param parentHospitalId
     * @return
     */
    private Boolean nameIsUnique(Integer materialId,String materialName,Integer parentHospitalId){
        BaseMaterial baseMaterial = this.selectByName(materialName, parentHospitalId);
        //名字唯一:插入时无baseMaterial,修改时返回值id和materialId相同
        if(null== baseMaterial|| null != baseMaterial && baseMaterial.getMaterialId().equals(materialId)){
            return true;
        }
        return false;
    }

    /**
     * 根据物资名字查询
     * @param materialName
     * @param parentHospitalId
     * @return
     */
    private BaseMaterial selectByName(String materialName,Integer parentHospitalId){
        MyIllegalArgumentException.checkTrue(StringUtils.isBlank(materialName),logger,"materialName不能为空");
        MyIllegalArgumentException.checkNull(parentHospitalId,logger,"parentHospitalId不能为null");
        BaseMaterialCriteria criteria = new BaseMaterialCriteria();
        criteria.or().andMaterialNameEqualTo(materialName).andParentHospitalIdEqualTo(parentHospitalId);
        return queryEntity(criteria);
    }

    @Override
    public void delete(Integer materialId) throws MyException {
        MyIllegalArgumentException.checkNull(materialId,logger,"materialId不能为null");
        BaseMaterial baseMaterial = this.selectById(materialId);
        baseMaterial.setStatus(MyEnums.Status.Delete.getCode());
        this.updateById(baseMaterial);
    }
}