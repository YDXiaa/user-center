package paydemo.uc.facade.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息查询响应.
 */
@Data
public class CustomerInfoQueryResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号.
     */
    private String customerNo;

    /**
     * 客户注册类型.
     */
    private String customerType;

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
     * 用户编号.
     */
    private String userNo;

    /**
     * 客户账户号.
     */
    private String customerAccNo;

    /**
     * 等级编码.
     */
    private String levelCode;

    /**
     * 用户级别.
     */
    private String levelName;

    /**
     * 用户等级积分.
     */
    private Long levelScore;

    /**
     * 昵称.
     */
    private String nickName;

    /**
     * 客户状态.
     */
    private String customerStatus;

    /**
     * 用户状态.
     */
    private String userStatus;

    /**
     * 用户实名状态.
     */
    private String realNameStatus;

}
