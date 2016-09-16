package com.provider.model;

import java.io.Serializable;
import java.util.Date;

public class BaseMaterial implements Serializable {
    private Integer materialId;

    private Integer orderNo;

    private String code;

    private String materialCode;

    private String materialName;

    private String materialSpec;

    private String mnemonicCode;

    private String materialUnit;

    private String classCode;

    private String className;

    private String plantingSysCode;

    private String plantingSysName;

    private Short status;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public BaseMaterial(Integer materialId, Integer orderNo, String code, String materialCode, String materialName, String materialSpec, String mnemonicCode, String materialUnit, String classCode, String className, String plantingSysCode, String plantingSysName, Short status, Date createTime, Date modifyTime) {
        this.materialId = materialId;
        this.orderNo = orderNo;
        this.code = code;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.materialSpec = materialSpec;
        this.mnemonicCode = mnemonicCode;
        this.materialUnit = materialUnit;
        this.classCode = classCode;
        this.className = className;
        this.plantingSysCode = plantingSysCode;
        this.plantingSysName = plantingSysName;
        this.status = status;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public BaseMaterial() {
        super();
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialSpec() {
        return materialSpec;
    }

    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec == null ? null : materialSpec.trim();
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode == null ? null : mnemonicCode.trim();
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit == null ? null : materialUnit.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getPlantingSysCode() {
        return plantingSysCode;
    }

    public void setPlantingSysCode(String plantingSysCode) {
        this.plantingSysCode = plantingSysCode == null ? null : plantingSysCode.trim();
    }

    public String getPlantingSysName() {
        return plantingSysName;
    }

    public void setPlantingSysName(String plantingSysName) {
        this.plantingSysName = plantingSysName == null ? null : plantingSysName.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", materialId=").append(materialId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", code=").append(code);
        sb.append(", materialCode=").append(materialCode);
        sb.append(", materialName=").append(materialName);
        sb.append(", materialSpec=").append(materialSpec);
        sb.append(", mnemonicCode=").append(mnemonicCode);
        sb.append(", materialUnit=").append(materialUnit);
        sb.append(", classCode=").append(classCode);
        sb.append(", className=").append(className);
        sb.append(", plantingSysCode=").append(plantingSysCode);
        sb.append(", plantingSysName=").append(plantingSysName);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}