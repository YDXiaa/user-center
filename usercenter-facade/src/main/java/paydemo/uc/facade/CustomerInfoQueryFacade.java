package paydemo.uc.facade;

import paydemo.uc.facade.model.CustomerInfoQueryRequestDTO;
import paydemo.uc.facade.model.CustomerInfoQueryResponse;
import paydemo.util.Response;

/**
 * @auther YDXiaa
 * <p>
 * 用户信息查询.
 */
public interface CustomerInfoQueryFacade {


    /**
     * 查询客户信息.
     *
     * @param requestDTO 请求对象.
     * @return 客户信息.
     */
    Response<CustomerInfoQueryResponse> queryCustomerInfo(CustomerInfoQueryRequestDTO requestDTO);

}
