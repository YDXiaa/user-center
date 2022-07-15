package paydemo.uc.biz.helper;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.util.ReUtil;
import paydemo.uc.facade.enums.LoginNoTypeEnum;

/**
 * @auther YDXiaa
 * <p>
 * 登录号类型转换工具.
 */
public final class LoginNoTypeUtil {

    /**
     * 根据正则规则转换登录号类型.
     *
     * @param loginNo 登录号.
     * @return 登录号类型.
     */
    public static LoginNoTypeEnum transferLoginNoType(final String loginNo) {

        if (ReUtil.isMatch(PatternPool.EMAIL, loginNo)) {
            return LoginNoTypeEnum.EMAIL;

        } else if (ReUtil.isMatch(PatternPool.MOBILE, loginNo)) {
            return LoginNoTypeEnum.MOBILE;

        } else {
            return LoginNoTypeEnum.AUTH;
        }
    }
}
