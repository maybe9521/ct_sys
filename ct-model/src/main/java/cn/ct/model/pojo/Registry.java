package cn.ct.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author ct.team
 * @Description 挂号单表
*/
public class Registry implements Serializable {
    /** 主键ID */
    private Long id;
    /** 病人表主键ID */
    private Long patientId;
    /** 排期表主键ID */
    private Long scheduleId;
    /** 用户表主键ID */
    private Long userId;
    /** 就诊科室表主键ID */
    private Long departmentId;
    /** 就诊房间表主键ID */
    private Long roomId;
    /** 挂号单状态 1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束 */
    private Integer status;
    /** 挂号费(￥) */
    private BigDecimal fee;
    /** 实际支付挂号费(￥) */
    private BigDecimal payFee;
    /** 医保报销费(￥) */
    private BigDecimal medicareFee;
    /** 是否使用医保卡 1-->未使用，2-->使用 */
    private Integer isMedicare;
    /** 挂号时间 */
    private Date registryTime;
    /** 医生问诊时间 */
    private Date consultationTime;
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
    public void setPatientId (Long  patientId){
        this.patientId=patientId;
    }
    public  Long getPatientId(){
        return this.patientId;
    }
    public void setScheduleId (Long  scheduleId){
        this.scheduleId=scheduleId;
    }
    public  Long getScheduleId(){
        return this.scheduleId;
    }
    public void setUserId (Long  userId){
        this.userId=userId;
    }
    public  Long getUserId(){
        return this.userId;
    }
    public void setDepartmentId (Long  departmentId){
        this.departmentId=departmentId;
    }
    public  Long getDepartmentId(){
        return this.departmentId;
    }
    public void setRoomId (Long  roomId){
        this.roomId=roomId;
    }
    public  Long getRoomId(){
        return this.roomId;
    }
    public void setStatus (Integer  status){
        this.status=status;
    }
    public  Integer getStatus(){
        return this.status;
    }
    public void setFee (BigDecimal  fee){
        this.fee=fee;
    }
    public  BigDecimal getFee(){
        return this.fee;
    }
    public void setPayFee (BigDecimal  payFee){
        this.payFee=payFee;
    }
    public  BigDecimal getPayFee(){
        return this.payFee;
    }
    public void setMedicareFee (BigDecimal  medicareFee){
        this.medicareFee=medicareFee;
    }
    public  BigDecimal getMedicareFee(){
        return this.medicareFee;
    }
    public void setIsMedicare (Integer  isMedicare){
        this.isMedicare=isMedicare;
    }
    public  Integer getIsMedicare(){
        return this.isMedicare;
    }
    public void setRegistryTime (Date  registryTime){
        this.registryTime=registryTime;
    }
    public  Date getRegistryTime(){
        return this.registryTime;
    }
    public void setConsultationTime (Date  consultationTime){
        this.consultationTime=consultationTime;
    }
    public  Date getConsultationTime(){
        return this.consultationTime;
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
