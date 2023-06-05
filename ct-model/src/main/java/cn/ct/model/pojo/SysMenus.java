package cn.ct.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ct.team
 * @Description 菜单表
 */
public class SysMenus implements Serializable {
    /** 编号 */
    private Long id;
    /** 菜单名称 */
    private String menuName;
    /** 菜单URL */
    private String menuUrl;
    /** 菜单类型 1-->1级菜单；2-->2级菜单 */
    private Integer menuType;
    /** 父级菜单编号 */
    private Long parentId;
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
    public void setMenuName (String  menuName){
        this.menuName=menuName;
    }
    public  String getMenuName(){
        return this.menuName;
    }
    public void setMenuUrl (String  menuUrl){
        this.menuUrl=menuUrl;
    }
    public  String getMenuUrl(){
        return this.menuUrl;
    }
    public void setMenuType (Integer  menuType){
        this.menuType=menuType;
    }
    public  Integer getMenuType(){
        return this.menuType;
    }
    public void setParentId (Long  parentId){
        this.parentId=parentId;
    }
    public  Long getParentId(){
        return this.parentId;
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
