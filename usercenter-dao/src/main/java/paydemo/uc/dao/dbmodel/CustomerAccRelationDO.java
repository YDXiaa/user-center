package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 账户操作权限信息: 客户、用户、账户的授权关系 类比RBAC模型.
 * <p>
 * 三户模型中 账户归属于客户,用户作为操作账户实体仅与 客户账户存在操作授权关系.
 */
@Getter
@Setter
@ToString
@TableName("T_CUSTOMER_ACC_RELATION")
public class CustomerAccRelationDO extends BaseDO {

    /**
     * 账户号.
     */
    private String customerNo;

    /**
     * 客户类型.
     */
    private String customerType;

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 客户账户号.
     */
    private String customerAccNo;

    /**
     * 个人客户accNo为空,目前只有企业才需要授权操作.
     */
    private String accNo;

    /**
     * 操作权限.
     */
    private String operateAuthorities;

    /**
     * 客户账户状态.
     */
    private String customerAccStatus;

}
