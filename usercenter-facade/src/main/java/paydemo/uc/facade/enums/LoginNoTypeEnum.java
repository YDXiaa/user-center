package paydemo.uc.facade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 登录号类型.
 */
@Getter
@AllArgsConstructor
public enum LoginNoTypeEnum {

    /**
     * 手机登录.
     */
    MOBILE("MOBILE", "手机号"),

    /**
     * 邮箱登录.
     */
    EMAIL("EMAIL", "邮箱登录"),

    /**
     * auth登录.
     */
    AUTH("AUTH", "外部授权认证登录(微信、支付宝、微博、google)");


    /**
     * 登录号类型编码.
     */
    private final String loginNoTypeCode;

    /**
     * 登录号类型描述.
     */
    private final String loginNoTypeDesc;
}
