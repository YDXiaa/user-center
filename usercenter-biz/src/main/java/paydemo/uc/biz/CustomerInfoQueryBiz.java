package paydemo.uc.biz;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paydemo.uc.biz.helper.LoginNoTypeUtil;
import paydemo.uc.common.exception.ResponseCodeEnum;
import paydemo.uc.common.exception.UcException;
import paydemo.uc.dao.dbmodel.*;
import paydemo.uc.manager.*;
import paydemo.uc.manager.model.CustomerInfoQueryReqBO;
import paydemo.uc.manager.model.CustomerInfoQueryRespBO;

import java.util.Objects;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息查询biz.
 */
@Service
public class CustomerInfoQueryBiz {

    @Autowired
    private UserInfoManager userInfoManager;

    @Autowired
    private UserLoginInfoManager userLoginInfoManager;

    @Autowired
    private CustomerAccRelationManager customerAccRelationManager;

    @Autowired
    private UserLevelInfoManager userLevelInfoManager;

    @Autowired
    private CustomerInfoManager customerInfoManager;


    /**
     * 查询客户信息.
     *
     * @param reqBO 用户登录信息.
     * @return 客户信息查询响应对象.
     */
    public CustomerInfoQueryRespBO queryCustomerInfo(CustomerInfoQueryReqBO reqBO) {

        // 自动转换登录号类型.
        if (StrUtil.isBlankIfStr(reqBO.getLoginNoType())) {
            reqBO.setLoginNoType(LoginNoTypeUtil.transferLoginNoType(reqBO.getLoginNo()).getLoginNoTypeCode());
        }

        // 查询用户登录信息.
        UserLoginInfoDO userLoginInfoDO = userLoginInfoManager.queryLoginNo(reqBO.getLoginNo(), reqBO.getLoginNoType(),
                reqBO.getLoginNoChannel());

        if (Objects.isNull(userLoginInfoDO)) {
            UcException.throwBizFailException(ResponseCodeEnum.LOGIN_NO_NOT_EXIST);
        }


        // 查询用户信息.
        UserInfoDO userInfoDO = userInfoManager.queryUserInfo(userLoginInfoDO.getUserNo());

        if (Objects.isNull(userInfoDO)) {
            UcException.throwBizFailException(ResponseCodeEnum.USER_NO_NOT_EXIST);
        }

        CustomerInfoQueryRespBO customerInfoQueryRespBO = BeanUtil.copyProperties(userInfoDO, CustomerInfoQueryRespBO.class);

        //查询用户等级信息.
        UserLevelInfoDO userLevelInfoDO = userLevelInfoManager.queryUserLevelInfo(userLoginInfoDO.getUserNo());

        customerInfoQueryRespBO.setLevelCode(userLevelInfoDO.getLevelCode());
        customerInfoQueryRespBO.setLevelName(userLevelInfoDO.getLevelName());
        customerInfoQueryRespBO.setLevelScore(userLevelInfoDO.getLevelScore());

        // 未实名.
        if (StrUtil.isBlankIfStr(customerInfoQueryRespBO.getCustomerNo())) {
            return customerInfoQueryRespBO;
        }

        // 查询客户信息.
        CustomerInfoDO customerInfoDO = customerInfoManager.queryCustomerInfo(customerInfoQueryRespBO.getCustomerNo());
        customerInfoQueryRespBO.setCustomerStatus(customerInfoDO.getCustomerStatus());
        customerInfoQueryRespBO.setNation(customerInfoDO.getNation());
        customerInfoQueryRespBO.setGender(customerInfoDO.getGender());
        customerInfoQueryRespBO.setBirthdate(customerInfoDO.getBirthdate());
        customerInfoQueryRespBO.setMaritalStatus(customerInfoDO.getMaritalStatus());
        customerInfoQueryRespBO.setEducation(customerInfoDO.getEducation());
        customerInfoQueryRespBO.setMajor(customerInfoDO.getMajor());
        customerInfoQueryRespBO.setGraduateSchool(customerInfoDO.getGraduateSchool());
        customerInfoQueryRespBO.setProfession(customerInfoDO.getProfession());

        // 查询客户账户信息.
        CustomerAccRelationDO accRelationDO = customerAccRelationManager.queryCustomerAccNoInfo(customerInfoQueryRespBO.getCustomerNo(),
                customerInfoQueryRespBO.getUserNo());

        customerInfoQueryRespBO.setCustomerAccNo(accRelationDO.getCustomerAccNo());

        return customerInfoQueryRespBO;
    }
}
