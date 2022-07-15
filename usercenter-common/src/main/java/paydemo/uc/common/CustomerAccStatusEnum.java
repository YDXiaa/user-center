package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 客户账户状态.
 */
@Getter
@AllArgsConstructor
public enum CustomerAccStatusEnum {

    /**
     * 正常.
     */
    NORNAL("NORMAL", "正常"),

    /**
     * 止入.
     */
    FORBID_FUND_IN("FORBID_FUND_IN", "止入"),

    /**
     * 止付.
     */
    FORBID_FUND_OUT("FORBID_FUND_OUT", "止付"),

    /**
     * 止入与止付.
     */
    FORBID_ALL("FORBID_ALL", "止入与止付"),
    ;


    /**
     * 账户操作权限编码.
     */
    private final String accOperateAuthCode;

    /**
     * 账户操作权限描述.
     */
    private final String accOperateAuthDesc;
}
