package paydemo.uc.facade;

import paydemo.uc.facade.model.CloseCustomerRequestDTO;
import paydemo.uc.facade.model.UserRealNameRequestDTO;
import paydemo.uc.facade.model.UserRegisterRequestDTO;
import paydemo.util.Response;

/**
 * @auther YDXiaa
 * <p>
 * 客户信息管理.
 * 1、注册用户.
 * 2、实名认证用户.
 * 3、销户.
 * 4、用户操作.
 */
public interface CustomerInfoManageFacade {

    /**
     * 用户非实名注册.
     *
     * @param requestDTO 请求对象.
     * @return 注册结果.
     */
    Response<Boolean> registerUser(UserRegisterRequestDTO requestDTO);


    /**
     * 用户实名认证.
     *
     * @param requestDTO 请求对象.
     * @return 认证结果.
     */
    Response<Boolean> realNameUser(UserRealNameRequestDTO requestDTO);


    /**
     * 客户销户.
     *
     * @param requestDTO 请求对象.
     * @return 销户结果.
     */
    Response<Boolean> closeCustomer(CloseCustomerRequestDTO requestDTO);

}
