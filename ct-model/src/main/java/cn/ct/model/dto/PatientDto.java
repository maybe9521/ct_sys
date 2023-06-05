package cn.ct.model.dto;
import java.io.Serializable;

/**
 * @author ct.team
 * @Description 病人表
*/
public class PatientDto implements Serializable {
    /** 主键ID */
    private Long id;
    /** 病人姓名 */
    private String name;
    /** 出生日期 */
    private String birthday;
    /** 性别 1-->女性，2-->男性 */
    private Integer sex;
    /** 家庭住址 */
    private String address;
    /** 联系方式 */
    private String phone;
    /** 身份证号 */
    private String idCard;
    /** 是否有医保卡 1-->没有，2-->有 */
    private Integer isMedicare;
    /** 医保卡号 */
    private String idMedicare;
    /** get set 方法 */
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setName (String  name){
        this.name=name;
    }
    public  String getName(){
        return this.name;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex (Integer  sex){
        this.sex=sex;
    }
    public  Integer getSex(){
        return this.sex;
    }
    public void setAddress (String  address){
        this.address=address;
    }
    public  String getAddress(){
        return this.address;
    }
    public void setPhone (String  phone){
        this.phone=phone;
    }
    public  String getPhone(){
        return this.phone;
    }
    public void setIdCard (String  idCard){
        this.idCard=idCard;
    }
    public  String getIdCard(){
        return this.idCard;
    }
    public void setIsMedicare (Integer  isMedicare){
        this.isMedicare=isMedicare;
    }
    public  Integer getIsMedicare(){
        return this.isMedicare;
    }
    public void setIdMedicare (String  idMedicare){
        this.idMedicare=idMedicare;
    }
    public  String getIdMedicare(){
        return this.idMedicare;
    }
}
