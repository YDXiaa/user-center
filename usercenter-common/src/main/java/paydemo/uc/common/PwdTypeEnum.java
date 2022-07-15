package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 密码类型.
 */
@Getter
@AllArgsConstructor
public enum PwdTypeEnum {

    /**
     * 登录密码.
     */
    LOGIN_PWD("LOGIN_PWD", "登录密码"),

    /**
     * 支付密码.
     */
    PAY_PWD("PAY_PWD", "支付密码"),

    ;


    /**
     * 密码类型编码.
     */
    private final String pwdTypeCode;

    /**
     * 密码类型描述.
     */
    private final String pwdTypeDesc;
    }
