package cn.ct.model.dto;
import java.io.Serializable;
import java.util.List;

/**
 * @author ct.team
 * @Description 菜单表
 */
public class SysMenuDto implements Serializable {
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
    private String createdTime;
    /** 修改时间 */
    private String updatedTime;

    /** 子菜单列表 */
    private List<SysSubMenuDto> subMenus;

    public List<SysSubMenuDto> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SysSubMenuDto> subMenus) {
        this.subMenus = subMenus;
    }

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
}
