package paydemo.uc.facade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 登录号渠道.
 */
@Getter
@AllArgsConstructor
public enum LoginNoChannelEnum {

    /**
     * 标准登录(包括手机号、邮箱).
     */
    STANDARD("STANDARD", "标准登录号渠道"),

    /**
     * 微信授权.
     */
    WECHAT("WECHAT", "微信授权"),

    /**
     * 谷歌授权.
     */
    GOOGLE("GOOGLE", "谷歌账号授权"),

    /**
     * 微博授权.
     */
    WEIBO("WEIBO", "微博授权"),

    /**
     * QQ授权.
     */
    QQ("QQ", "QQ授权"),

    ;


    /**
     * 登录号类型编码.
     */
    private final String loginNoChannelCode;

    /**
     * 登录号类型描述.
     */
    private final String loginNoChannelDesc;
}
