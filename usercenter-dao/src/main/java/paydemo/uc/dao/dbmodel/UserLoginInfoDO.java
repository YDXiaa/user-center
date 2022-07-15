package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户登录信息表.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_LOGIN_INFO")
public class UserLoginInfoDO extends BaseDO {

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 登录号类型 EMAIL/PHONE/OAUTH2.
     */
    private String loginNoType;

    /**
     * 登录号.
     */
    private String loginNo;

    /**
     * 登录渠道 WECHAT/WEIBO.
     */
    private String loginNoChannel;

    /**
     * 外部授权登录时登录关联appid.
     */
    private String appid;

    /**
     * 登录号状态(正常、已经被更换绑定).
     */
    private String loginNoStatus;

}
