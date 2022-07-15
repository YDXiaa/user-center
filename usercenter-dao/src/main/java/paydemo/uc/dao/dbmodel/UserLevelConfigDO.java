package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户level配置表.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_USER_LEVEL_CONFIG")
public class UserLevelConfigDO extends BaseDO {

    /**
     * 等级编码.
     */
    private String levelCode;

    /**
     * 等级描述(例如白金会员、黄金会员...).
     */
    private String levelName;

    /**
     * 等级描述.
     */
    private String levelDesc;

    /**
     * 等级起始点分数.
     */
    private long levelStartScore;

    /**
     * 等级结束点分数.
     */
    private long levelEndScore;
}
