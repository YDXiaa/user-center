package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 用户密码表.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_PWD")
public class UserPwdDO extends BaseDO {

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * 密码类型(LOGIN_PWD/PAY_PWD).
     */
    private String pwdType;

    /**
     * 加密类型(兼容后期加密方式升级).
     */
    private String encryType;

    /**
     * 加密用户密码.
     */
    private String encryPwd;

    /**
     * 密码状态(随机密码需要重新设置、正常、锁定).
     */
    private String pwdStatus;

    /**
     * 密码验证错误次数 系统中最大输入错误次数后将会被锁定.
     */
    private Long pwdErrorTimes;

    /**
     * 锁定原因(密码输入次数过多).
     */
    private String lockReason;

    /**
     * 锁定释放时间.
     */
    private Date lockReleaseTime;
}
