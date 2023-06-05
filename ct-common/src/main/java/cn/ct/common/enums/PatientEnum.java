package cn.ct.common.enums;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public enum PatientEnum {

    PATIENT_NO_MEDICARE(1,"没有医保卡"),
    PATIENT_MEDICARE(2,"有医保卡"),

    PATIENT_SEX_WOMAN(1,"女"),
    PATIENT_SEX_MAN(2,"男");

    private Integer code;
    private String msg;
    private PatientEnum(Integer code , String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
