package cn.ct.model.dto;
import java.io.Serializable;

/**
 * @author ct.team
 * @Description 菜单表
 */
public class SysSubMenuDto implements Serializable {
    /** 编号 */
    private Long subId;
    /** 菜单名称 */
    private String subMenuName;
    /** 菜单URL */
    private String subMenuUrl;
    /** 菜单类型 1-->1级菜单；2-->2级菜单 */
    private Integer subMenuType;
    /** 父级菜单编号 */
    private Long subParentId;
    /** 创建时间 */
    private String createdTime;
    /** 修改时间 */
    private String updatedTime;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    /** get set 方法 */


    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    public String getSubMenuUrl() {
        return subMenuUrl;
    }

    public void setSubMenuUrl(String subMenuUrl) {
        this.subMenuUrl = subMenuUrl;
    }

    public Integer getSubMenuType() {
        return subMenuType;
    }

    public void setSubMenuType(Integer subMenuType) {
        this.subMenuType = subMenuType;
    }

    public Long getSubParentId() {
        return subParentId;
    }

    public void setSubParentId(Long subParentId) {
        this.subParentId = subParentId;
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
