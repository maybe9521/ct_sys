package cn.ct.model.req;

import java.io.Serializable;

/**
 * @author ct.team
 * @Description 用户查询入参包装类
 * Version 1.0
 */
public class SysUserReq implements Serializable {
    /**主键ID */
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
    /** 创建人ID */
    private Long createdUserId;

    /** 页码 */
    private Integer pageNo;
    /** 页长 */
    private Integer pageSize;
    /** 数据库分页查询开始 */
    private Integer beginPos;

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

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
