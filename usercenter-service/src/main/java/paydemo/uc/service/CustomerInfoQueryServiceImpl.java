package paydemo.uc.service;

import cn.hutool.core.bean.BeanUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import paydemo.uc.biz.CustomerInfoQueryBiz;
import paydemo.uc.facade.CustomerInfoQueryFacade;
import paydemo.uc.facade.model.CustomerInfoQueryRequestDTO;
import paydemo.uc.facade.model.CustomerInfoQueryResponse;
import paydemo.uc.manager.model.CustomerInfoQueryReqBO;
import paydemo.uc.manager.model.CustomerInfoQueryRespBO;
import paydemo.util.Response;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息查询.
 */
@Service
public class CustomerInfoQueryServiceImpl implements CustomerInfoQueryFacade {


    @Autowired
    private CustomerInfoQueryBiz customerInfoQueryBiz;


    @Override
    public Response<CustomerInfoQueryResponse> queryCustomerInfo(CustomerInfoQueryRequestDTO requestDTO) {

        CustomerInfoQueryReqBO customerInfoQueryReqBO = BeanUtil.copyProperties(requestDTO, CustomerInfoQueryReqBO.class);

        CustomerInfoQueryRespBO customerInfo = customerInfoQueryBiz.queryCustomerInfo(customerInfoQueryReqBO);

        CustomerInfoQueryResponse customerQueryResponse = BeanUtil.copyProperties(customerInfo, CustomerInfoQueryResponse.class);

        return Response.createSuccessResponse(customerQueryResponse);
    }
}
