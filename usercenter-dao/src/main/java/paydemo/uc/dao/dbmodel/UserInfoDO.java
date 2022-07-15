package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 用户信息.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_INFO")
public class UserInfoDO extends BaseDO {

    /**
     * 客户编号.
     */
    private String customerNo;

    /**
     * 客户注册类型.
     */
    private String customerType;

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * 用户角色.
     */
    private String userRole;

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
     * 昵称.
     */
    private String nickName;

    /**
     * 用户头像.
     */
    private String userHeadPic;

    /**
     * 自我介绍.
     */
    private String introduction;

    /**
     * 用户状态.
     */
    private String userStatus;

    /**
     * 用户实名状态.
     */
    private String realNameStatus;

    /**
     * 用户创建时间.
     */
    private Date userCreateDate;

}
