package cn.ct.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ct.team
 * @Description 挂号单表
*/
public class RegistryDto implements Serializable {
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
    private String statusName;
    /** 挂号费(￥) */
    private BigDecimal fee;
    /** 实际支付挂号费(￥) */
    private BigDecimal payFee;
    /** 医保报销费(￥) */
    private BigDecimal medicareFee;
    /** 是否使用医保卡 1-->未使用，2-->使用 */
    private Integer isMedicare;
    /** 挂号时间 */
    private String registryTime;
    /** 医生问诊时间 */
    private String consultationTime;
    /** 创建时间 */
    private String createdTime;

    /** 病人姓名 */
    private String patientName;
    /** 病人性别 */
    private Integer patientSex;
    private String patientSexName;
    /** 病人身份证号 */
    private String patientIdCard;
    /** 病人出生日期 */
    private String patientBirthday;
    /** 家庭住址 */
    private String patientAddress;
    /** 就诊科室 */
    private String departmentName;
    /** 挂号医生姓名 */
    private String doctorName;
    /** 就诊房间 */
    private String roomName;



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

    public String getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(String registryTime) {
        this.registryTime = registryTime;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Integer patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientIdCard() {
        return patientIdCard;
    }

    public void setPatientIdCard(String patientIdCard) {
        this.patientIdCard = patientIdCard;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPatientSexName() {
        return patientSexName;
    }

    public void setPatientSexName(String patientSexName) {
        this.patientSexName = patientSexName;
    }

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
