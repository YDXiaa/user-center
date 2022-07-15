package paydemo.uc.facade;

import paydemo.uc.facade.model.OAuthLoginNoRequestDTO;
import paydemo.util.Response;

/**
 * @auther YDXiaa
 * <p>
 * 用户信息.
 * 1、修改个人信息(昵称、个人基本信息、密保问题)
 * 2、新增、修改登录号、绑定外部微信支付宝账号
 * 3、修改登录、支付密码
 * 4、用户状态变更
 * 5、用户登录
 */
public interface UserInfoManageFacade {

    /**
     * 新增外部认证登录号.
     *
     * @param requestDTO 请求对象.
     * @return 新增结果.
     */
    Response<Boolean> addOAuthLoginNo(OAuthLoginNoRequestDTO requestDTO);

}
