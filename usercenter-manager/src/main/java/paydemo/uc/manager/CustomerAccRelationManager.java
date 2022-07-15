package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.CustomerAccRelationDO;
import paydemo.uc.dao.mapper.CustomerAccRelationMapper;

/**
 * @auther YDXiaa
 * <p>
 * 客户关联关系manager.
 */
@Repository
public class CustomerAccRelationManager {

    @Autowired
    private CustomerAccRelationMapper customerAccRelationMapper;

    /**
     * 查询三户关联关系.
     *
     * @param customerNo 客户编号.
     * @param userNo     用户编号.
     * @return 三户关联关系.
     */
    public CustomerAccRelationDO queryCustomerAccNoInfo(String customerNo, String userNo) {

        LambdaQueryWrapper<CustomerAccRelationDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerAccRelationDO::getCustomerNo, customerNo)
                .eq(CustomerAccRelationDO::getUserNo, userNo);

        return customerAccRelationMapper.selectOne(queryWrapper);
    }
}
