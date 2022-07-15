package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 密码状态.
 */
@Getter
@AllArgsConstructor
public enum PwdStatusEnum {

    /**
     * 未设置密码.
     */
    NOTSET("NOTSET", "未设置密码"),

    /**
     * 已设置密码.
     */
    NORMAL("NORMAL", "已设置密码"),

    /**
     * 密码被锁定.
     */
    LOCK("LOCK","密码被锁定")

    ;


    /**
     * 密码类型编码.
     */
    private final String pwdStatusCode;

    /**
     * 密码类型描述.
     */
    private final String pwdStatusDesc;
    }
