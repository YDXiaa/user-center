package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 客户黑名单.
 */
@Getter
@Setter
@ToString(callSuper = true)
@TableName("T_CUSTOMER_BLACK_LIST")
public class CustomerBlackListDO extends BaseDO {

    /**
     * 证件类型.
     */
    private String certType;

    /**
     * 证件号.
     */
    private String certNo;

    /**
     * 客户黑名单状态.
     */
    private String blackListStatus;

}
