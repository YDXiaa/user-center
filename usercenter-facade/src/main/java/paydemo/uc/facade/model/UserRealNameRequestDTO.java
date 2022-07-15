package paydemo.uc.facade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 用户实名请求.
 */
@Data
public class UserRealNameRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 用户证件类型.
     */
    private String certType;

    /**
     * 用户证件号.
     */
    private String certNo;

    /**
     * 证件姓名.
     */
    private String certName;

    /**
     * 证件生效日期.
     */
    private Date certEffectDate;

    /**
     * 证件失效日期.
     */
    private Date certExpireDate;

    /**
     * 国家默认CN中国.
     */
    private String nation;

    /**
     * 性别.
     */
    private String gender;

    /**
     * 出生日期.
     */
    private Date birthdate;

    /**
     * 婚姻状态.
     */
    private String maritalStatus;

    /**
     * 教育信息（学历）.
     */
    private String education;

    /**
     * 教育信息(专业).
     */
    private String major;

    /**
     * 教育信息(院校).
     */
    private String graduateSchool;

    /**
     * 常住地址.
     */
    private String permanentAddress;

    /**
     * 职业.
     */
    private String profession;

}
