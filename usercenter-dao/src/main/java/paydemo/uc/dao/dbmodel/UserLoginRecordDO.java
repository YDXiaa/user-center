package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 用户登录记录.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_LOGIN_RECORD")
public class UserLoginRecordDO extends BaseDO {

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 登录号.
     */
    private String loginNo;

    /**
     * 登录号类型.
     */
    private String loginNoType;

    /**
     * 登录号渠道.
     */
    private String loginNoChannel;

    /**
     * 登录设备号.
     */
    private String loginDeviceNo;

    /**
     * 登录设备系统 IOS/ANDROID/MAC/WINDOWS/WATCH/....
     */
    private String loginDevicePlatform;

    /**
     * 登录设备型号.
     */
    private String loginDeviceModelNo;

    /**
     * 登录应用版本.
     */
    private String loginAppVersion;

    /**
     * 登录ip.
     */
    private String loginIp;

    /**
     * 登录ip省份编码.
     */
    private String loginProvinceCode;

    /**
     * 登录ip地市编码.
     */
    private String loginCityCode;

    /**
     * 登录日期.
     */
    private Date loginDate;

    /**
     * 登录状态 LOGIN_SUCCESS、LOGIN_FAIL.
     */
    private String loginStatus;


}
