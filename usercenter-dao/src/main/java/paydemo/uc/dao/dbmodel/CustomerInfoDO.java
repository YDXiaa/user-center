package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息，目前只针对个人客户，如果区分个人与企业，应针对此表进行拓展.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_CUSTOMER_INFO")
public class CustomerInfoDO extends BaseDO {

    /**
     * 客户号.
     */
    private String customerNo;

    /**
     * 客户类型(个人/企业).
     */
    private String customerType;

    /**
     * 客户名称.
     */
    private String customerName;

    /**
     * 证件类型 ID_CARD 身份证.
     */
    private String certType;

    /**
     * 证件号.
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

    /**
     * 客户状态(客户状态影响客户号下面所有用户和账户).
     */
    private String customerStatus;

}
