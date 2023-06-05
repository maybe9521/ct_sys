package cn.ct.common.util;

/**
 * @author ct.team
 * @Description 常量类
 * Version 1.0
 */
public class Constants {
    /** session */
    public final static String USER_SESSION = "userSession";

    /** 分页相关 */
    public final static Integer DEFAULT_PAGE_NO = 1;
    public final static Integer DEFAULT_PAGE_SIZE = 10;

    /** 上传文件大小上限 */
    public static final Integer FILE_SIZE = 500000;
    /** 文件格式 */
    public static final String FILE_JPG = "jpg";
    public static final String FILE_PNG = "png";
    public static final String FILE_JEPG = "jepg";
    public static final String FILE_PNEG = "pneg";
    public static final String FILE_JPEG = "jpeg";
    /** 默认头像相对路径 */
    public static final String FILE_DEFAULT_HEAD_PATH = "/statics/images/img1.jpg";

    /** 挂号费 */
    public static final Integer REGISTRY_FEE = 50;
    /** 未使用医保-医保报销额 */
    public static final Integer REGISTRY_NO_MEDICARE_FEE = 0;
    /** 使用医保-医保报销额：报销80% */
    public static final Integer REGISTRY_MEDICARE_FEE = 40;
    /** 使用医保标识 */
    public static final String SIGN_MEDICARE = "medicare";
}
