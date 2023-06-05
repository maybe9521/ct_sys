package cn.ct.model.dto;
import java.io.Serializable;

/**
 * @author ct.team
 * @Description 医嘱表
*/
public class MedicalAdviceDto implements Serializable {
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
    private String createdTime;
    /** 修改时间 */
    private String updatedTime;

    /** 就诊医师姓名 */
    private String doctorName;
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
    public void setChiefComplaint (String chiefComplaint){
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
