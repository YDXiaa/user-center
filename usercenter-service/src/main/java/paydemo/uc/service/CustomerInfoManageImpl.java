package paydemo.uc.service;

import cn.hutool.core.bean.BeanUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import paydemo.uc.biz.CustomerInfoBiz;
import paydemo.uc.facade.CustomerInfoManageFacade;
import paydemo.uc.facade.model.CloseCustomerRequestDTO;
import paydemo.uc.facade.model.UserRealNameRequestDTO;
import paydemo.uc.facade.model.UserRegisterRequestDTO;
import paydemo.uc.manager.model.UserRealNameRequestBO;
import paydemo.uc.manager.model.UserRegisterRequestBO;
import paydemo.uc.manager.model.UserSecQuestInfoBO;
import paydemo.util.Response;

import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息管理.
 */
@Service
public class CustomerInfoManageImpl implements CustomerInfoManageFacade {

    @Autowired
    private CustomerInfoBiz customerInfoBiz;


    @Override
    public Response<Boolean> registerUser(UserRegisterRequestDTO requestDTO) {

        UserRegisterRequestBO registerRequestBO = BeanUtil.copyProperties(requestDTO, UserRegisterRequestBO.class);
        List<UserSecQuestInfoBO> userSecQuestInfoBOList = BeanUtil.copyToList(requestDTO.getUserSecQuestInfoRequestDTOList(),
                UserSecQuestInfoBO.class);
        registerRequestBO.setUserSecQuestInfoBOList(userSecQuestInfoBOList);

        Boolean userRegisterResult = customerInfoBiz.registerUser(registerRequestBO);

        return Response.createSuccessResponse(userRegisterResult);
    }

    @Override
    public Response<Boolean> realNameUser(UserRealNameRequestDTO requestDTO) {

        UserRealNameRequestBO userRealNameRequestBO = BeanUtil.copyProperties(requestDTO, UserRealNameRequestBO.class);
        Boolean userRealNameResult = customerInfoBiz.realNameUser(userRealNameRequestBO);

        return Response.createSuccessResponse(userRealNameResult);
    }

    @Override
    public Response<Boolean> closeCustomer(CloseCustomerRequestDTO requestDTO) {
        return null;
    }
}
