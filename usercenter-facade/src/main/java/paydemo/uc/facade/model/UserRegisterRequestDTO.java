package paydemo.uc.facade.model;

import lombok.Data;
import paydemo.uc.facade.enums.LoginNoChannelEnum;
import paydemo.uc.facade.enums.LoginNoTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * 用户注册请求对象.
 */
@Data
public class UserRegisterRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 登录号.
     */
    private String loginNo;

    /**
     * 客户注册类型.
     */
    private String customerType;

    /**
     * 登录号类型.
     */
    private String loginNoType;

    /**
     * 登录号具体渠道(例如登录号类型为oauth，渠道为 weibo/wechat/google).
     */
    private String loginNoChannel = LoginNoChannelEnum.STANDARD.getLoginNoChannelCode();

    /**
     * appid.
     */
    private String appid;

    /**
     * 登录密码.
     */
    private String loginPwd;

    /**
     * 登录密码加密类型 默认国密SM4算法.
     */
    private String pwdEncryType;

    /**
     * 昵称(如果是外部授权获得).
     */
    private String nickName;

    /**
     * 用户头像cdn地址.
     */
    private String userHeadPic;

    /**
     * 请求设备ip.
     */
    private String requestIp;

    /**
     * 用户密保问题.
     */
    private List<UserSecQuestInfoRequestDTO> userSecQuestInfoRequestDTOList;

}
