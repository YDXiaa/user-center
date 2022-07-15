package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 账户授权操作权限.
 */
@Getter
@AllArgsConstructor
public enum AccAuthorityEnum {

    /**
     * 最高权限.
     */
    SUPER("SUPER", "最高权限"),
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
