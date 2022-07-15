package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 认证子类型.
 */
@Getter
@AllArgsConstructor
public enum AuthSubTypeEnum {

    /**
     * 证件号+姓名.
     */
    IDCARD_NO_NAME("IDCARD_NO_NAME", "证件号+姓名"),

    /**
     * 证件号 + 姓名 + 手机号.
     */
    IDCARD_NO_NAME_MOBILE("IDCARD_NO_NAME_MOBILE", "证件号 + 姓名 + 手机号"),

    /**
     * 证件号 + 姓名 + 银行卡号.
     */
    BANKCARD_IDCARD_NO_NAME("BANKCARD_IDCARD_NO_NAME", "证件号 + 姓名 + 银行卡号"),

    /**
     * 企业三要素验证.
     */
    COMPANY_INDUSTRY("COMPANY_INDUSTRY", "企业三要素认证");

    /**
     * 认证类型编码.
     */
    private final String authSubTypeCode;

    /**
     * 认证类型描述.
     */
    private final String authSubTypeDesc;

}
