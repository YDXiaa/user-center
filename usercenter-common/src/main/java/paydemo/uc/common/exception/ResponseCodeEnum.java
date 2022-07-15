package paydemo.uc.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {

    /**
     * 业务处理成功.
     */
    BIZ_SUCCESS("BIZ_SUCCESS", "业务处理成功"),

    /**
     * 系统发生错误.
     */
    SYS_ERROR("SYS_ERROR", "系统处理错误"),

    /**
     * 登录号已存在.
     */
    LOGIN_NO_EXISTS("LOGIN_NO_EXISTS", "登录号已存在"),

    /**
     * 登录信息不存在.
     */
    LOGIN_NO_NOT_EXIST("LOGIN_NO_NOT_EXIST", "登录信息不存在"),

    /**
     * 必须绑定手机号.
     */
    REQUIRED_BIND_MOBILE("REQUIRED_BIND_MOBILE", "必须绑定手机号"),

    /**
     * 用户号不存在.
     */
    USER_NO_NOT_EXIST("USER_NO_NOT_EXIST", "用户编号不存在"),

    /**
     * 参数验证失败.
     */
    PARAM_VERIFY_FAIL("PARAM_VERIFY_FAIL", "参数验证失败"),

    /**
     * 实名认证不通过.
     */
    REALNAME_NOT_PASS("REALNAME_NOT_PASS", "实名认证不通过"),

    /**
     * 证件信息在黑名单中,无法实名.
     */
    CERT_INFO_IN_BLACKLIST("CERT_INFO_IN_BLACKLIST", "证件信息在黑名单中,无法实名"),

    ;

    /**
     * 响应结果码.
     */
    private final String respCode;

    /**
     * 响应结果信息.
     */
    private final String respDesc;
}
