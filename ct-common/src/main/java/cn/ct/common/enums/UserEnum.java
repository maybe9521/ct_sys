package cn.ct.common.enums;

/**
 * @author ct.team
 * @Description 用户相关枚举类
 * Version 1.0
 */
public enum UserEnum {
    USER_TYPE_ADMIN(1,"系统管理员"),
    USER_TYPE_REGISTER(2,"挂号员"),
    USER_TYPE_DOCTER(3,"门诊医师"),
    USER_TYPE_CHECKER(4,"收银员"),
    USER_TYPE_PHARMACY_DOCTER(5,"药房医师");

    private Integer code;
    private String msg;
    private UserEnum(Integer code , String msg){
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
