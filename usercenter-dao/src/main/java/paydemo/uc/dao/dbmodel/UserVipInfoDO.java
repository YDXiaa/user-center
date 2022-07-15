package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户vip信息表.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_VIP_INFO")
public class UserVipInfoDO extends BaseDO {

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * viP类型.
     */
    private String vipType;

    /**
     * 业务线.
     */
    private String bizLine;


}
