package cn.ct.model.dto;

import java.io.Serializable;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public class SysUserDto implements Serializable {
    /** 主键ID */
    private Long id;
    /** 就诊科室ID */
    private Long departmentId;
    /** 用户类型 1-->系统管理员；2-->挂号员；3-->门诊医师；4-->收银员；5-->药方医师 */
    private Integer userType;
    /** 用户头像URL */
    private String headUrl;
    /** 账号 */
    private String account;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 盐值 */
    private String salt;
    /** 创建时间 */
    private String createdTime;
    /** 修改时间 */
    private String updatedTime;
    /** 创建人ID */
    private Long createdUserId;

    /** 用户类型名称 */
    private String userTypeName;

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }
}
