package cn.ct.model.req;
import java.io.Serializable;

/**
 * @author ct.team
 * @Description 医嘱表
*/
public class MedicalAdviceReq implements Serializable {
    /** 挂号单表主键ID */
    private Long registryId;
    /** 就诊医师用户ID */
    private Long userId;
    /** 病人主诉 */
    private String chiefComplaint;
    /** 诊断情况 */
    private String diagnosis;
    /** get set 方法 */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
