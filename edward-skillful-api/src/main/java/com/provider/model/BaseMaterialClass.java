package com.provider.model;

import java.io.Serializable;
import java.util.Date;

public class BaseMaterialClass implements Serializable {
    private Integer classId;

    private String className;

    private String classCode;

    private Integer parentHospitalId;

    private String parentClassCode;

    private Integer orderNo;

    private Short classStatus;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public BaseMaterialClass(Integer classId, String className, String classCode, Integer parentHospitalId, String parentClassCode, Integer orderNo, Short classStatus, Date createTime, Date modifyTime) {
        this.classId = classId;
        this.className = className;
        this.classCode = classCode;
        this.parentHospitalId = parentHospitalId;
        this.parentClassCode = parentClassCode;
        this.orderNo = orderNo;
        this.classStatus = classStatus;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public BaseMaterialClass() {
        super();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public Integer getParentHospitalId() {
        return parentHospitalId;
    }

    public void setParentHospitalId(Integer parentHospitalId) {
        this.parentHospitalId = parentHospitalId;
    }

    public String getParentClassCode() {
        return parentClassCode;
    }

    public void setParentClassCode(String parentClassCode) {
        this.parentClassCode = parentClassCode == null ? null : parentClassCode.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Short getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(Short classStatus) {
        this.classStatus = classStatus;
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
        sb.append(", classId=").append(classId);
        sb.append(", className=").append(className);
        sb.append(", classCode=").append(classCode);
        sb.append(", parentHospitalId=").append(parentHospitalId);
        sb.append(", parentClassCode=").append(parentClassCode);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", classStatus=").append(classStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}