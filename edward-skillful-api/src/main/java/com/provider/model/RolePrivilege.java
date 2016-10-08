package com.provider.model;

import java.io.Serializable;
import java.util.Date;

public class RolePrivilege implements Serializable {
    private Integer recordId;

    private Integer roleId;

    private String privilegeCode;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public RolePrivilege(Integer recordId, Integer roleId, String privilegeCode, Date createTime, Date modifyTime) {
        this.recordId = recordId;
        this.roleId = roleId;
        this.privilegeCode = privilegeCode;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public RolePrivilege() {
        super();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode == null ? null : privilegeCode.trim();
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
        sb.append(", recordId=").append(recordId);
        sb.append(", roleId=").append(roleId);
        sb.append(", privilegeCode=").append(privilegeCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}