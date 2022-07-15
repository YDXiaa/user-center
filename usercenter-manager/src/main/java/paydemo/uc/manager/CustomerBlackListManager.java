package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.CustomerBlackListDO;
import paydemo.uc.dao.mapper.CustomerBlackListMapper;
import paydemo.util.UsableEnum;

/**
 * @auther YDXiaa
 * <p>
 * 客户黑名单.
 */
@Repository
public class CustomerBlackListManager {

    @Autowired
    private CustomerBlackListMapper customerBlackListMapper;

    /**
     * 查询客户黑名单.
     *
     * @param certType 证件类型.
     * @param certNo   证件号.
     * @return 证件是否在黑名单中.
     */
    public boolean queryCustomerBlackList(String certType, String certNo) {

        LambdaQueryWrapper<CustomerBlackListDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerBlackListDO::getCertType, certType)
                .eq(CustomerBlackListDO::getCertNo, certNo)
                .eq(CustomerBlackListDO::getBlackListStatus, UsableEnum.NORMAL.getUsableCode());

        return null != customerBlackListMapper.selectOne(queryWrapper);
    }


}
