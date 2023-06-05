package cn.ct.model.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ct.team
 * @Description 挂号单表
*/
public class RegistryReq implements Serializable {
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
    /** 挂号费(￥) */
    private BigDecimal fee;
    /** 实际支付挂号费(￥) */
    private BigDecimal payFee;
    /** 医保报销费(￥) */
    private BigDecimal medicareFee;
    /** 是否使用医保卡 1-->未使用，2-->使用 */
    private Integer isMedicare;
    /** 挂号单状态 1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束 */
    private Integer status;
    /** 医生问诊时间 */
    private Date consultationTime;
    /** 医保卡号 */
    private String idMedicare;

    /** 病人身份证号 */
    private String idCard;
    /** 页码 */
    private Integer pageNo;
    /** 页长 */
    private Integer pageSize;
    /** 数据库分页查询开始 */
    private Integer beginPos;

    /** get set 方法 */
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Date consultationTime) {
        this.consultationTime = consultationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdMedicare() {
        return idMedicare;
    }

    public void setIdMedicare(String idMedicare) {
        this.idMedicare = idMedicare;
    }
}
