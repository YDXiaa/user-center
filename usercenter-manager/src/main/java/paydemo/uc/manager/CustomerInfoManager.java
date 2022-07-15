package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import paydemo.uc.dao.dbmodel.*;
import paydemo.uc.dao.mapper.*;

import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息管理.
 */
@Repository
public class CustomerInfoManager {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserLoginInfoMapper userLoginInfoMapper;

    @Autowired
    private UserPwdMapper userPwdMapper;

    @Autowired
    private UserLevelInfoMapper userLevelInfoMapper;

    @Autowired
    private UserSecQuestInfoMapper userSecQuestInfoMapper;

    @Autowired
    private AccInfoMapper accInfoMapper;

    @Autowired
    private CustomerAccRelationMapper customerAccRelationMapper;

    @Autowired
    private UserAuthInfoMapper userAuthInfoMapper;


    /**
     * 注册用户.
     *
     * @param createUserInfo             用户信息.
     * @param createUserLoginInfo        用户登录号信息.
     * @param createUserPwd              用户密码信息.
     * @param createUserLevelInfo        用户等级信息.
     * @param createUserSecQuestInfoList 用户密保问题.
     * @return 添加注册用户结果.
     */
    @Transactional(rollbackFor = Throwable.class)
    public Boolean addRegisterUser(UserInfoDO createUserInfo, UserLoginInfoDO createUserLoginInfo,
                                   UserPwdDO createUserPwd, UserLevelInfoDO createUserLevelInfo,
                                   List<UserSecQuestInfoDO> createUserSecQuestInfoList) {

        userInfoMapper.insert(createUserInfo);
        userLoginInfoMapper.insert(createUserLoginInfo);
        userPwdMapper.insert(createUserPwd);
        userLevelInfoMapper.insert(createUserLevelInfo);
        createUserSecQuestInfoList.forEach(createUserSecQuestInfo -> userSecQuestInfoMapper.insert(createUserSecQuestInfo));

        return true;
    }

    /**
     * 查询同一证件信息实名客户是否存在.
     *
     * @param certType 证件类型.
     * @param certNo   证件号.
     * @return 客户信息.
     */
    public CustomerInfoDO queryCertExists(String certType, String certNo) {

        LambdaQueryWrapper<CustomerInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerInfoDO::getCertType, certType)
                .eq(CustomerInfoDO::getCertNo, certNo);

        return customerInfoMapper.selectOne(queryWrapper);
    }

    /**
     * 添加新客户.
     *
     * @param modifyUserInfo            用户信息.
     * @param createAccInfo             账户信息.
     * @param createCustomerAccRelation 三户关联关系.
     * @param mergeCustomerFlag         归并客户标识.
     */
    @Transactional(rollbackFor = Throwable.class)
    public void addCustomerInfo(UserInfoDO modifyUserInfo, CustomerInfoDO createCustomerInfo, AccInfoDO createAccInfo,
                                CustomerAccRelationDO createCustomerAccRelation, UserAuthInfoDO createUserAuthInfo,
                                boolean mergeCustomerFlag) {

        if (!mergeCustomerFlag) {
            customerInfoMapper.insert(createCustomerInfo);
        }

        LambdaUpdateWrapper<UserInfoDO> userInfoUpdateWrapper = new LambdaUpdateWrapper<>();
        userInfoUpdateWrapper.set(UserInfoDO::getCustomerNo, modifyUserInfo.getCustomerNo())
                .set(UserInfoDO::getCertType, modifyUserInfo.getCertType())
                .set(UserInfoDO::getCertNo, modifyUserInfo.getCertNo())
                .set(UserInfoDO::getCertEffectDate, modifyUserInfo.getCertEffectDate())
                .set(UserInfoDO::getCertExpireDate, modifyUserInfo.getCertExpireDate())
                .set(UserInfoDO::getCertName, modifyUserInfo.getCertName())
                .set(UserInfoDO::getRealNameStatus, modifyUserInfo.getRealNameStatus())
                .eq(UserInfoDO::getUserNo, modifyUserInfo.getUserNo());
        userInfoMapper.update(modifyUserInfo, userInfoUpdateWrapper);

        userAuthInfoMapper.insert(createUserAuthInfo);
        accInfoMapper.insert(createAccInfo);
        customerAccRelationMapper.insert(createCustomerAccRelation);
    }

    /**
     * 根据客户编号查询客户信息.
     *
     * @param customerNo 客户编号.
     * @return 客户信息.
     */
    public CustomerInfoDO queryCustomerInfo(String customerNo) {

        LambdaQueryWrapper<CustomerInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerInfoDO::getCustomerNo, customerNo);

        return customerInfoMapper.selectOne(queryWrapper);
    }
}
