package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户级别信息.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_LEVEL_INFO")
public class UserLevelInfoDO extends BaseDO {

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 等级编码.
     */
    private String levelCode;

    /**
     * 用户级别.
     */
    private String levelName;

    /**
     * 用户等级积分.
     */
    private Long levelScore;

}
