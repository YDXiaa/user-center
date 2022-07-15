package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户配置信息.
 */
@Getter
@Setter
@ToString
@TableName("T_USER_SETTING_CONFIG")
public class UserSettingConfigDO extends BaseDO {

    /**
     * 用户编号.
     */
    private String userNo;

    /**
     * 配置分类.
     */
    private String configGroup;

    /**
     * 配置业务类型.
     */
    private String configBizType;

    /**
     * 配置类型 开关类.
     */
    private String configType;

}
