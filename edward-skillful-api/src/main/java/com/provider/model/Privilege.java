package com.provider.model;

import java.io.Serializable;
import java.util.Date;

public class Privilege implements Serializable {
    private Integer privilegeId;

    private String privilegeCode;

    private String privilegeName;

    private String url;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Privilege(Integer privilegeId, String privilegeCode, String privilegeName, String url, String remark, Date createTime, Date modifyTime) {
        this.privilegeId = privilegeId;
        this.privilegeCode = privilegeCode;
        this.privilegeName = privilegeName;
        this.url = url;
        this.remark = remark;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public Privilege() {
        super();
    }

    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode == null ? null : privilegeCode.trim();
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", privilegeId=").append(privilegeId);
        sb.append(", privilegeCode=").append(privilegeCode);
        sb.append(", privilegeName=").append(privilegeName);
        sb.append(", url=").append(url);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}