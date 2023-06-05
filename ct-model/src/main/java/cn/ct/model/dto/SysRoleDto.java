package cn.ct.model.dto;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ct.team
 * @Description 角色表
*/
public class SysRoleDto implements Serializable {
    /** 角色编号 */
    private Long id;
    /** 角色名称 */
    private String roleName;
    /** 角色描述 */
    private String description;
    /** 是否锁定 1-->未锁定；2-->锁定 */
    private Integer isLock;
    /** 创建时间 */
    private Date createdTime;
    /** 修改时间 */
    private Date updatedTime;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setRoleName (String  roleName){
        this.roleName=roleName;
    }
    public  String getRoleName(){
        return this.roleName;
    }
    public void setDescription (String  description){
        this.description=description;
    }
    public  String getDescription(){
        return this.description;
    }
    public void setIsLock (Integer  isLock){
        this.isLock=isLock;
    }
    public  Integer getIsLock(){
        return this.isLock;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
}
