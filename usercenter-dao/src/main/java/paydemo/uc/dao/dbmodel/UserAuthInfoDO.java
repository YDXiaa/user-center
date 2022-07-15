package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户认证信息.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_AUTH_INFO")
public class UserAuthInfoDO extends BaseDO {

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 认证证件类型.
     */
    private String authCertType;

    /**
     * 认证证件号.
     */
    private String authCertNo;

    /**
     * 认证客户姓名.
     */
    private String authCustomerName;

    /**
     * 认证用户手机号.
     */
    private String authCustomerMobile;

    // 交由认证路由.

    /**
     * 认证路由通道编码.
     */
    private String channelDetailNo;

    /**
     * 认证类型(二要素、三要素认证).
     */
    private String authType;

    /**
     * 认证分类细类.
     */
    private String authSubType;

    /**
     * 认证渠道.
     */
    private String authChannel;

}
