package paydemo.uc.manager.model;

import lombok.Data;
import paydemo.uc.dao.dbmodel.UserSecQuestInfoDO;

import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * userRegisterBO.
 */
@Data
public class UserRegisterRequestBO {

    /**
     * 用户号.
     */
    private String userNo;

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
    private String loginNoChannel;

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
     * 昵称.
     */
    private String nickName;

    /**
     * 用户头像.
     */
    private String userHeadPic;

    /**
     * 请求设备ip.
     */
    private String requestIp;

    /**
     * 用户密保问题.
     */
    private List<UserSecQuestInfoBO> userSecQuestInfoBOList;

}
