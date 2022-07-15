package paydemo.uc.biz;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paydemo.uc.biz.helper.LoginNoTypeUtil;
import paydemo.uc.common.*;
import paydemo.uc.common.exception.ResponseCodeEnum;
import paydemo.uc.common.exception.UcException;
import paydemo.uc.dao.dbmodel.*;
import paydemo.uc.facade.enums.IdentityStatusEnum;
import paydemo.uc.facade.enums.LoginNoTypeEnum;
import paydemo.uc.manager.*;
import paydemo.uc.manager.helper.CustomerNoCreator;
import paydemo.uc.manager.model.UserRealNameRequestBO;
import paydemo.uc.manager.model.UserRegisterRequestBO;
import paydemo.util.AccClassifyEnum;
import paydemo.util.AccTypeEnum;
import paydemo.util.FlagsEnum;
import paydemo.util.UsableEnum;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息biz.
 */
@Service
public class CustomerInfoBiz {

    @Autowired
    private CustomerInfoManager customerInfoManager;

    @Autowired
    private UserInfoManager userInfoManager;

    @Autowired
    private UserLoginInfoManager userLoginInfoManager;

    @Autowired
    private UserLevelConfigManager userLevelConfigManager;

    @Autowired
    private CustomerBlackListManager customerBlackListManager;

    /**
     * 注册用户.
     *
     * @param userRegisterRequestBO 用户注册信息.
     * @return 注册结果.
     */
    public Boolean registerUser(UserRegisterRequestBO userRegisterRequestBO) {

        // 转换类型.
        if (StrUtil.isBlankIfStr(userRegisterRequestBO.getLoginNoType())) {
            LoginNoTypeEnum loginNoTypeEnum = LoginNoTypeUtil.transferLoginNoType(userRegisterRequestBO.getLoginNoType());
            userRegisterRequestBO.setLoginNoType(loginNoTypeEnum.getLoginNoTypeCode());
        }

        // 登录号是否存在.
        UserLoginInfoDO userLoginInfoDO = userLoginInfoManager.queryLoginNo(userRegisterRequestBO.getLoginNo(),
                userRegisterRequestBO.getLoginNoType(), userRegisterRequestBO.getLoginNoChannel());

        if (Objects.nonNull(userLoginInfoDO)) {
            UcException.throwBizFailException(ResponseCodeEnum.LOGIN_NO_EXISTS);
        }

        // 创建用户信息.
        UserInfoDO createUserInfo = createUserInfo(userRegisterRequestBO);

        // 创建登录信息.
        UserLoginInfoDO createUserLoginInfo = createUserLoginInfo(userRegisterRequestBO);

        // 创建登录密码.
        UserPwdDO createUserPwd = createUserPwd(userRegisterRequestBO);

        // 创建用户等级信息.
        UserLevelInfoDO createUserLevelInfo = createUserLevelInfo(userRegisterRequestBO);

        // 创建密保问题.
        List<UserSecQuestInfoDO> createUserSecQuestInfoList = createUserSecQuestInfo(userRegisterRequestBO);

        // 落库.
        return customerInfoManager.addRegisterUser(createUserInfo, createUserLoginInfo, createUserPwd,
                createUserLevelInfo, createUserSecQuestInfoList);
    }

    /**
     * 用户密保问题.
     *
     * @param userRegisterRequestBO 注册信息.
     * @return 用户密保问题.
     */
    private List<UserSecQuestInfoDO> createUserSecQuestInfo(UserRegisterRequestBO userRegisterRequestBO) {
        return userRegisterRequestBO.getUserSecQuestInfoBOList().stream().map(userSecQuestInfoBO -> {
            UserSecQuestInfoDO userSecQuestInfoDO = new UserSecQuestInfoDO();
            userSecQuestInfoDO.setUserNo(userRegisterRequestBO.getUserNo());
            userSecQuestInfoDO.setSeq(userSecQuestInfoBO.getSeq());
            userSecQuestInfoDO.setSecQuestion(userSecQuestInfoBO.getSecQuestion());
            userSecQuestInfoDO.setSecQuestionAnswer(userSecQuestInfoBO.getSecQuestionAnswer());
            return userSecQuestInfoDO;
        }).collect(Collectors.toList());
    }

    /**
     * 用户成长等级信息.
     *
     * @param userRegisterRequestBO 注册信息.
     * @return 用户成长等级信息.
     */
    private UserLevelInfoDO createUserLevelInfo(UserRegisterRequestBO userRegisterRequestBO) {

        UserLevelInfoDO userLevelInfoDO = new UserLevelInfoDO();

        userLevelInfoDO.setUserNo(userRegisterRequestBO.getUserNo());
        // 默认0.
        userLevelInfoDO.setLevelScore(0L);
        // 查询等级配置
        UserLevelConfigDO userLevelConfigDO = userLevelConfigManager.queryUserLevelConfig(userLevelInfoDO.getLevelScore());
        userLevelInfoDO.setLevelCode(userLevelConfigDO.getLevelCode());
        userLevelInfoDO.setLevelName(userLevelConfigDO.getLevelName());

        return userLevelInfoDO;
    }

    private UserPwdDO createUserPwd(UserRegisterRequestBO userRegisterRequestBO) {

        UserPwdDO userPwdDO = new UserPwdDO();

        userPwdDO.setUserNo(userRegisterRequestBO.getUserNo());
        userPwdDO.setPwdType(PwdTypeEnum.LOGIN_PWD.getPwdTypeCode());
        userPwdDO.setEncryType("MD5"); // 暂时以MD5处理,应以国密/RSA/或者加密机处理.
        userPwdDO.setPwdErrorTimes(0L);

        // 通过外部账号授权注册,无登录密码.
        if (LoginNoTypeEnum.AUTH.getLoginNoTypeCode().equals(userRegisterRequestBO.getLoginNoType())) {
            userPwdDO.setPwdStatus(PwdStatusEnum.NOTSET.getPwdStatusCode());
        } else {
            userPwdDO.setPwdStatus(PwdStatusEnum.NORMAL.getPwdStatusCode());
            userPwdDO.setEncryPwd(MD5.create().digestHex(userRegisterRequestBO.getLoginPwd()));
        }

        return userPwdDO;
    }

    private UserLoginInfoDO createUserLoginInfo(UserRegisterRequestBO userRegisterRequestBO) {

        UserLoginInfoDO userLoginInfoDO = new UserLoginInfoDO();

        userLoginInfoDO.setUserNo(userRegisterRequestBO.getUserNo());
        userLoginInfoDO.setLoginNoType(userRegisterRequestBO.getLoginNoType());
        userLoginInfoDO.setLoginNo(userRegisterRequestBO.getLoginNo());
        userLoginInfoDO.setLoginNoChannel(userRegisterRequestBO.getLoginNoChannel());
        userLoginInfoDO.setAppid(userRegisterRequestBO.getAppid());
        userLoginInfoDO.setLoginNoStatus(UsableEnum.NORMAL.getUsableCode());

        return userLoginInfoDO;
    }

    /**
     * 创建用户信息.
     *
     * @param userRegisterRequestBO 用户注册信息.
     * @return 用户信息.
     */
    private UserInfoDO createUserInfo(UserRegisterRequestBO userRegisterRequestBO) {

        String userNo = CustomerNoCreator.createUserNo(userRegisterRequestBO.getCustomerType());
        userRegisterRequestBO.setUserNo(userNo);

        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserNo(userRegisterRequestBO.getUserNo());
        userInfoDO.setCustomerType(userRegisterRequestBO.getCustomerType());
        userInfoDO.setUserRole(UserRoleEnum.PRIMARY.getUserRoleCode());
        userInfoDO.setNickName(userRegisterRequestBO.getNickName());
        userInfoDO.setUserHeadPic(userRegisterRequestBO.getUserHeadPic());
        userInfoDO.setRealNameStatus(FlagsEnum.FALSE.getFlagCode());
        userInfoDO.setUserStatus(IdentityStatusEnum.NORMAL.getUserStatusCode());
        userInfoDO.setUserCreateDate(new Date());
        return userInfoDO;
    }

    /**
     * 用户实名.
     *
     * @param userRealNameRequestBO 实名请求对象.
     * @return 实名结果.
     */
    public Boolean realNameUser(UserRealNameRequestBO userRealNameRequestBO) {

        // 是否在客户黑名单中.
        if(customerBlackListManager.queryCustomerBlackList(userRealNameRequestBO.getCertType(),userRealNameRequestBO.getCertNo())){
            UcException.throwBizFailException(ResponseCodeEnum.LOGIN_NO_EXISTS);
        }

        // 查询用户是否存在.
        UserInfoDO userInfoDO = userInfoManager.queryUserInfo(userRealNameRequestBO.getUserNo());

        if (Objects.isNull(userInfoDO)) {
            UcException.throwBizFailException(ResponseCodeEnum.USER_NO_NOT_EXIST);
        }

        //  设置客户类型.
        userRealNameRequestBO.setCustomerType(userInfoDO.getCustomerType());

        // 查询是否绑定手机号,必须绑定手机号去运营商三要素验证.
        List<UserLoginInfoDO> loginInfoList = userLoginInfoManager.queryUserLoginInfoByUserNo(userRealNameRequestBO.getUserNo());
        UserLoginInfoDO mobileLoginNoInfo = loginInfoList.stream().filter(userLoginInfoDO -> StrUtil.equals(LoginNoTypeEnum.MOBILE.getLoginNoTypeCode(),
                userLoginInfoDO.getLoginNoType())).findFirst().orElseThrow(() -> new UcException(ResponseCodeEnum.REQUIRED_BIND_MOBILE));

        userRealNameRequestBO.setMobile(mobileLoginNoInfo.getLoginNo());

        // 查询客户证件信息是否存在.
        CustomerInfoDO customerInfoDO = customerInfoManager.queryCertExists(userRealNameRequestBO.getCertType(),
                userRealNameRequestBO.getCertNo());

        // 认证系统进行运营商三要素验证.
        boolean authReslt = identityAuth(userRealNameRequestBO);

        if (!authReslt) {
            UcException.throwBizFailException(ResponseCodeEnum.REALNAME_NOT_PASS);
        }

        // 归并客户.
        if (Objects.nonNull(customerInfoDO)) {
            mergeCustomerInfo(userRealNameRequestBO);
        } else {
            // 创建新客户.
            createNewCustomer(userRealNameRequestBO);
        }

        return true;
    }

    /**
     * 三要素身份验证.
     * <p>
     * // todo 临时固定写死.
     *
     * @param userRealNameRequestBO 用户实名对象.
     * @return 请求对象.
     */
    private boolean identityAuth(UserRealNameRequestBO userRealNameRequestBO) {

        userRealNameRequestBO.setAuthType(AuthTypeEnum.IDENTITY_AUTH.getAuthTypeCode());
        userRealNameRequestBO.setAuthSubType(AuthSubTypeEnum.IDCARD_NO_NAME_MOBILE.getAuthSubTypeCode());

        return true;
    }

    /**
     * 创建新客户.
     *
     * @param userRealNameRequestBO 实名请求对象.
     */
    private void createNewCustomer(UserRealNameRequestBO userRealNameRequestBO) {

        // 创建客户号.
        String customerNo = CustomerNoCreator.createCustomerNo(userRealNameRequestBO.getCustomerType());
        userRealNameRequestBO.setCustomerNo(customerNo);

        // 创建客户信息.
        CustomerInfoDO createCustomerInfo = createCustomerInfo(userRealNameRequestBO);

        // 修改用户信息.
        UserInfoDO modifyUserInfo = modifyUserInfo(userRealNameRequestBO);

        // 创建认证信息.
        UserAuthInfoDO createUserAuthInfo = createUserAuthInfo(userRealNameRequestBO);

        // 创建账户信息.
        AccInfoDO createAccInfo = createAccInfoNo(userRealNameRequestBO);

        // 创建三户关联信息.
        CustomerAccRelationDO createCustomerAccRelation = createCustomerAccRelation(userRealNameRequestBO);

        // 落库.
        customerInfoManager.addCustomerInfo(modifyUserInfo, createCustomerInfo, createAccInfo, createCustomerAccRelation,
                createUserAuthInfo, false);
    }

    /**
     * 创建账户信息.
     *
     * @param userRealNameRequestBO 实名请求对象.
     * @return 账户信息.
     */
    private AccInfoDO createAccInfoNo(UserRealNameRequestBO userRealNameRequestBO) {

        // todo 暂时个人账户.
        String accNo = CustomerNoCreator.createAccNo(AccClassifyEnum.PERSON);
        String customerAccNo = CustomerNoCreator.createCustomerAccNo(userRealNameRequestBO.getCustomerType());
        userRealNameRequestBO.setAccNo(accNo);
        userRealNameRequestBO.setCustomerAccNo(customerAccNo);

        AccInfoDO accInfoDO = new AccInfoDO();
        accInfoDO.setCustomerAccNo(customerAccNo);
        accInfoDO.setAccNo(accNo);
        accInfoDO.setAccClassify(AccClassifyEnum.PERSON.getAccClassifyCode());
        accInfoDO.setAccType(AccTypeEnum.BALANCE.getAccTypeCode());
        accInfoDO.setCcy("156");
        accInfoDO.setDrcrFlag("CR");
        accInfoDO.setAllowOverDraft(FlagsEnum.FALSE.getFlagCode());
        accInfoDO.setAccCreateDate(new Date());
        return accInfoDO;
    }


    /**
     * 客户用户账户关联信息.
     *
     * @param userRealNameRequestBO 实名请求对象.
     * @return 三户关联关系.
     */
    private CustomerAccRelationDO createCustomerAccRelation(UserRealNameRequestBO userRealNameRequestBO) {

        CustomerAccRelationDO customerAccRelationDO = new CustomerAccRelationDO();

        customerAccRelationDO.setCustomerNo(userRealNameRequestBO.getCustomerNo());
        customerAccRelationDO.setCustomerType(userRealNameRequestBO.getCustomerType());
        customerAccRelationDO.setUserNo(userRealNameRequestBO.getUserNo());
        customerAccRelationDO.setCustomerAccNo(userRealNameRequestBO.getCustomerAccNo());
        customerAccRelationDO.setAccNo(userRealNameRequestBO.getAccNo());
        customerAccRelationDO.setOperateAuthorities(AccAuthorityEnum.SUPER.getAccOperateAuthCode());
        customerAccRelationDO.setCustomerAccStatus(IdentityStatusEnum.NORMAL.getUserStatusCode());

        return customerAccRelationDO;
    }

    /**
     * 创建客户信息.
     *
     * @param userRealNameRequestBO 实名请求对象.
     * @return 客户信息.
     */
    private CustomerInfoDO createCustomerInfo(UserRealNameRequestBO userRealNameRequestBO) {

        CustomerInfoDO customerInfoDO = new CustomerInfoDO();

        customerInfoDO.setCustomerNo(userRealNameRequestBO.getCustomerNo());
        customerInfoDO.setCustomerType(userRealNameRequestBO.getCustomerType());
        customerInfoDO.setCustomerName(userRealNameRequestBO.getCertName());
        customerInfoDO.setCertType(userRealNameRequestBO.getCertType());
        customerInfoDO.setCertNo(userRealNameRequestBO.getCertNo());
        customerInfoDO.setCertName(userRealNameRequestBO.getCertName());
        customerInfoDO.setCertEffectDate(userRealNameRequestBO.getCertEffectDate());
        customerInfoDO.setCertExpireDate(userRealNameRequestBO.getCertExpireDate());
        customerInfoDO.setNation(userRealNameRequestBO.getNation());
        customerInfoDO.setGender(userRealNameRequestBO.getGender());
        customerInfoDO.setBirthdate(userRealNameRequestBO.getBirthdate());
        customerInfoDO.setMaritalStatus(userRealNameRequestBO.getMaritalStatus());
        customerInfoDO.setEducation(userRealNameRequestBO.getEducation());
        customerInfoDO.setMajor(userRealNameRequestBO.getMajor());
        customerInfoDO.setGraduateSchool(userRealNameRequestBO.getGraduateSchool());
        customerInfoDO.setPermanentAddress(userRealNameRequestBO.getPermanentAddress());
        customerInfoDO.setProfession(userRealNameRequestBO.getProfession());
        customerInfoDO.setCustomerStatus(IdentityStatusEnum.NORMAL.getUserStatusCode());

        return customerInfoDO;
    }

    /**
     * 合并客户信息.
     *
     * @param userRealNameRequestBO 实名请求对象.
     */
    private void mergeCustomerInfo(UserRealNameRequestBO userRealNameRequestBO) {

        // 修改用户信息.
        UserInfoDO modifyUserInfo = modifyUserInfo(userRealNameRequestBO);

        // 创建账户信息.
        AccInfoDO createAccInfo = createAccInfoNo(userRealNameRequestBO);

        // 创建认证信息.
        UserAuthInfoDO createUserAuthInfo = createUserAuthInfo(userRealNameRequestBO);

        // 创建三户关联信息.
        CustomerAccRelationDO createCustomerAccRelation = createCustomerAccRelation(userRealNameRequestBO);

        // 落库.
        customerInfoManager.addCustomerInfo(modifyUserInfo, null, createAccInfo, createCustomerAccRelation,
                createUserAuthInfo, true);
    }

    /**
     * 用户认证信息.
     *
     * @param userRealNameRequestBO 实名请求对象.
     * @return 用户认证信息.
     */
    private UserAuthInfoDO createUserAuthInfo(UserRealNameRequestBO userRealNameRequestBO) {

        UserAuthInfoDO userAuthInfoDO = new UserAuthInfoDO();

        userAuthInfoDO.setUserNo(userRealNameRequestBO.getUserNo());
        userAuthInfoDO.setAuthCertType(userRealNameRequestBO.getCertType());
        userAuthInfoDO.setAuthCertNo(userRealNameRequestBO.getCertNo());
        userAuthInfoDO.setAuthCustomerName(userRealNameRequestBO.getCertName());
        userAuthInfoDO.setAuthCustomerMobile(userRealNameRequestBO.getMobile());
        userAuthInfoDO.setChannelDetailNo(userRealNameRequestBO.getChannelDetailNo());
        userAuthInfoDO.setAuthType(userRealNameRequestBO.getAuthType());
        userAuthInfoDO.setAuthSubType(userRealNameRequestBO.getAuthSubType());

        return userAuthInfoDO;
    }

    /**
     * 更新用户信息.
     *
     * @param userRealNameRequestBO 实名信息.
     * @return 用户信息.
     */
    private UserInfoDO modifyUserInfo(UserRealNameRequestBO userRealNameRequestBO) {

        UserInfoDO userInfoDO = new UserInfoDO();

        userInfoDO.setUserNo(userRealNameRequestBO.getUserNo());
        userInfoDO.setCustomerNo(userRealNameRequestBO.getCustomerNo());
        userInfoDO.setCertType(userRealNameRequestBO.getCertType());
        userInfoDO.setCertNo(userRealNameRequestBO.getCertNo());
        userInfoDO.setCertName(userRealNameRequestBO.getCertName());
        userInfoDO.setCertEffectDate(userRealNameRequestBO.getCertEffectDate());
        userInfoDO.setCertExpireDate(userRealNameRequestBO.getCertExpireDate());
        userInfoDO.setRealNameStatus(FlagsEnum.TRUE.getFlagCode());

        return userInfoDO;

    }
}
