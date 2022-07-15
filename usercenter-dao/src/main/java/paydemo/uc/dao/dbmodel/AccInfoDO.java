package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @auther YDXiaa
 * <p>
 * 账户信息表(只存储基础账户信息,其他余额、科目相关在账务、会计系统中).
 */
@Getter
@Setter
@ToString
@TableName("T_ACC_INFO")
public class AccInfoDO extends BaseDO {

    /**
     * 客户账户号.
     */
    private String customerAccNo;

    /**
     * 账户账号.
     */
    private String accNo;

    /**
     * 账户分类(个人、企业、内部).
     */
    private String accClassify;

    /**
     * 账户类型.
     */
    private String accType;

    /**
     * 币种(默认156 人民币).
     */
    private String ccy;

    /**
     * 借贷标识.
     */
    private String drcrFlag;

    /**
     * 透支标识.
     */
    private String allowOverDraft;

    /**
     * 开户时间.
     */
    private Date accCreateDate;

}
