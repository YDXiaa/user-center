package paydemo.uc.facade.model;

import lombok.Data;
import paydemo.uc.facade.enums.LoginNoChannelEnum;

import java.io.Serializable;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息查询请求.
 */
@Data
public class CustomerInfoQueryRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号.
     */
    private String loginNo;

    /**
     * 登录号类型.
     */
    private String loginNoType;

    /**
     * 登录号渠道(外部绑定使用).
     */
    private String loginNoChannel = LoginNoChannelEnum.STANDARD.getLoginNoChannelCode();
}
