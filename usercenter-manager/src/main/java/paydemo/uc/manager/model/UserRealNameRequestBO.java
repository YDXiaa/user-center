package paydemo.uc.manager.model;

import lombok.Data;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 用户实名请求对象.
 */
@Data
public class UserRealNameRequestBO {


    /**
     * 客户编号.
     */
    private String customerNo;

    /**
     * 客户类型.
     */
    private String customerType;

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * 手机号.
     */
    private String mobile;

    /**
     * 客户账户编号.
     */
    private String customerAccNo;

    /**
     * 账户编号.
     */
    private String accNo;

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
     * 客户归并标识.
     */
    private boolean mergeCustomerFlag;

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
     * 认证路由通道编码.
     */
    private String channelDetailNo;

    /**
     * 认证大类
     */
    private String authType;

    /**
     * 认证分类细类.
     */
    private String authSubType;

}
