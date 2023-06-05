package cn.ct.model.pojo;
import java.io.Serializable;
import java.util.Date;
/**
 * @author ct.team
 * @Description 医嘱表
*/
public class MedicalAdvice implements Serializable {
    /** 主键ID */
    private Long id;
    /** 挂号单表主键ID */
    private Long registryId;
    /** 就诊医师用户ID */
    private Long userId;
    /** 病人主诉 */
    private String chiefComplaint;
    /** 诊断情况 */
    private String diagnosis;
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
    public void setRegistryId (Long  registryId){
        this.registryId=registryId;
    }
    public  Long getRegistryId(){
        return this.registryId;
    }
    public void setChiefComplaint (String  chiefComplaint){
        this.chiefComplaint=chiefComplaint;
    }
    public  String getChiefComplaint(){
        return this.chiefComplaint;
    }
    public void setDiagnosis (String  diagnosis){
        this.diagnosis=diagnosis;
    }
    public  String getDiagnosis(){
        return this.diagnosis;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
