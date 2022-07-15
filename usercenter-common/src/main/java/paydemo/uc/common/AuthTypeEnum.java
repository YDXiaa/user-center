package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 认证类型.
 */
@Getter
@AllArgsConstructor
public enum AuthTypeEnum {

    /**
     * 身份认证.
     */
    IDENTITY_AUTH("IDENTITY_AUTH", "身份认证"),
    ;

    /**
     * 认证类型编码.
     */
    private final String authTypeCode;

    /**
     * 认证类型描述.
     */
    private final String authTypeDesc;

}
