package paydemo.uc.manager.model;

import lombok.Data;

/**
 * @auther YDXiaa
 * <p>
 * 客户查询对象.
 */
@Data
public class CustomerInfoQueryReqBO {

    /**
     * 用户编号.
     */
    private String loginNo;

    /**
     * 登录号类型.
     */
    private String loginNoType;

    /**
     * 登录号渠道.
     */
    private String loginNoChannel;

}
