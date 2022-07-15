package paydemo.uc.web;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import paydemo.uc.facade.CustomerInfoQueryFacade;
import paydemo.uc.facade.enums.LoginNoChannelEnum;
import paydemo.uc.facade.enums.LoginNoTypeEnum;
import paydemo.uc.dao.dbmodel.UserLevelConfigDO;
import paydemo.uc.facade.CustomerInfoManageFacade;
import paydemo.uc.facade.model.*;
import paydemo.uc.manager.UserLevelConfigManager;
import paydemo.util.CustomerTypeEnum;
import paydemo.util.FlagsEnum;
import paydemo.util.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * customerInfo.
 */
@Slf4j
public class CustomerInfoTest extends BaseSpringBootSupport {

    @Autowired
    private UserLevelConfigManager userLevelConfigManager;

    @Autowired
    private CustomerInfoManageFacade customerInfoManageFacade;

    @Autowired
    private CustomerInfoQueryFacade customerInfoQueryFacade;

    @Test
    public void testAddUserLevelConfig(){

        UserLevelConfigDO userLevelConfigDO = new UserLevelConfigDO();

        userLevelConfigDO.setLevelCode("BRONZE");
        userLevelConfigDO.setLevelName("青铜会员");
        userLevelConfigDO.setLevelDesc("青铜会员");
        userLevelConfigDO.setLevelStartScore(0L);
        userLevelConfigDO.setLevelEndScore(1000L);

        userLevelConfigManager.addUserLevelConfig(userLevelConfigDO);

    }

    @Test
    public void testRegisterUser(){

        UserRegisterRequestDTO requestDTO = new UserRegisterRequestDTO();
        requestDTO.setLoginNo("16666666666");
        requestDTO.setCustomerType(CustomerTypeEnum.PER.getCustomerTypeCode());
        requestDTO.setLoginNoType(LoginNoTypeEnum.MOBILE.getLoginNoTypeCode());
        requestDTO.setLoginNoChannel(LoginNoChannelEnum.STANDARD.getLoginNoChannelCode());
        requestDTO.setLoginPwd("123456");
        requestDTO.setPwdEncryType("MD5");
        requestDTO.setNickName("superSuperSuperVip");
        requestDTO.setUserHeadPic("cdn.baidu.com/user/headPic");
        requestDTO.setRequestIp("localhost");

        List<UserSecQuestInfoRequestDTO> userSecQuestInfoRequestDTOList = new ArrayList<>();

        UserSecQuestInfoRequestDTO userSecQuestInfoRequestDTO = new UserSecQuestInfoRequestDTO();
        userSecQuestInfoRequestDTO.setSeq(1);
        userSecQuestInfoRequestDTO.setSecQuestion("毕业学校是哪里");
        userSecQuestInfoRequestDTO.setSecQuestionAnswer("TingHua");


        userSecQuestInfoRequestDTOList.add(userSecQuestInfoRequestDTO);

        requestDTO.setUserSecQuestInfoRequestDTOList(userSecQuestInfoRequestDTOList);


        customerInfoManageFacade.registerUser(requestDTO);

    }

    @Test
    public void testRealName(){

        UserRealNameRequestDTO requestDTO = new UserRealNameRequestDTO();
        requestDTO.setUserNo("30994134791881109325");
        requestDTO.setCertType("IDCARD");
        requestDTO.setCertNo("310000000000");
        requestDTO.setCertName("SuperPeter");
        requestDTO.setCertEffectDate(DateUtil.parse("2010-08-25"));
        requestDTO.setCertExpireDate(DateUtil.parse("2030-08-25"));
        requestDTO.setNation("CN");
        requestDTO.setGender("M");
        requestDTO.setBirthdate(DateUtil.parse("1990-08-25"));
        requestDTO.setMaritalStatus(FlagsEnum.FALSE.getFlagCode());
        requestDTO.setEducation("硕士");
        requestDTO.setMajor("AI学院");
        requestDTO.setGraduateSchool("清华大学");
        requestDTO.setPermanentAddress("五道口");
        requestDTO.setProfession("开发工程师");

        customerInfoManageFacade.realNameUser(requestDTO);
    }

    @Test
    public void queryCustomerInfo(){

        CustomerInfoQueryRequestDTO requestDTO = new CustomerInfoQueryRequestDTO();
        requestDTO.setLoginNo("16666666666");

        Response<CustomerInfoQueryResponse> response = customerInfoQueryFacade.queryCustomerInfo(requestDTO);

        log.info("查询结果信息:{}",response.getRespData());

    }
}
