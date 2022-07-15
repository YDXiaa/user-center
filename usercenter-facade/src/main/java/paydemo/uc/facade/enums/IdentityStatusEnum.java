package paydemo.uc.facade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 用户/客户/账户状态.
 */
@Getter
@AllArgsConstructor
public enum IdentityStatusEnum {

    /**
     * 正常状态.
     */
    NORMAL("NORMAL", "正常状态"),

    /**
     * 锁定.
     */
    LOCK("LOCK", "锁定状态"),

    /**
     * 冻结状态.
     */
    CLOSE("CLOSE", "注销状态");


    /**
     * 用户状态编码.
     */
    private final String userStatusCode;

    /**
     * 用户状态描述.
     */
    private final String userStatusDesc;
}
