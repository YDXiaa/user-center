package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户绑定设备.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_BIND_DEVICE")
public class UserBindDeviceDO extends BaseDO {

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * 设备号.
     */
    private String deviceNo;

    /**
     * 设备类型 PAD/PHONE/.
     */
    private String deviceType;

    /**
     * 设备型号 IPHONE13.
     */
    private String deviceModelNo;

    /**
     * 设备操作系统 ANDROID/IOS/WINDOWS.
     */
    private String devicePlatform;

    /**
     * 设备系统版本例如 IOS 13.2.
     */
    private String devicePlatformVersion;

    /**
     * app应用软件版本号.
     */
    private String appVersion;

}
