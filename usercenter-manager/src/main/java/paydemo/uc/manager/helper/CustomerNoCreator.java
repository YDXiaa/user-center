package paydemo.uc.manager.helper;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import paydemo.uc.common.exception.ResponseCodeEnum;
import paydemo.uc.common.exception.UcException;
import paydemo.util.AccClassifyEnum;
import paydemo.util.CustomerTypeEnum;

/**
 * @auther YDXiaa
 * <p>
 * 客户号生成工具(长度20位).
 * <p>
 * 规则：
 * 客户编号号:1-2 (1、个人 2、企业)
 * 用户编号：3-4 (3、个人 4、企业)
 * 客户账户编号：5-6 (5、个人 6、企业)
 * 账户号: 789 (7、个人 8、企业 9、内部)
 */
public class CustomerNoCreator {

    /**
     * 创建客户号.
     *
     * @param customerType 客户类型.
     * @return 客户号.
     */
    public static String createCustomerNo(final String customerType) {

        if (CustomerTypeEnum.PER.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "1", RandomUtil.randomNumbers(19));
        } else if (CustomerTypeEnum.ORG.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "2", RandomUtil.randomNumbers(19));
        } else {
            UcException.throwBizFailException(ResponseCodeEnum.PARAM_VERIFY_FAIL);
        }

        return null;
    }

    /**
     * 创建用户号.
     *
     * @param customerType 客户类型.
     * @return 用户号.
     */
    public static String createUserNo(final String customerType) {
        if (CustomerTypeEnum.PER.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "3", RandomUtil.randomNumbers(19));
        } else if (CustomerTypeEnum.ORG.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "4", RandomUtil.randomNumbers(19));
        } else {
            UcException.throwBizFailException(ResponseCodeEnum.PARAM_VERIFY_FAIL);
        }

        return null;
    }

    /**
     * 创建客户账户编号.
     *
     * @param customerType 客户类型.
     * @return 客户账户编号.
     */
    public static String createCustomerAccNo(final String customerType) {
        if (CustomerTypeEnum.PER.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "5", RandomUtil.randomNumbers(19));
        } else if (CustomerTypeEnum.ORG.getCustomerTypeCode().equals(customerType)) {
            return StrUtil.concat(false, "6", RandomUtil.randomNumbers(19));
        } else {
            UcException.throwBizFailException(ResponseCodeEnum.PARAM_VERIFY_FAIL);
        }

        return null;
    }

    /**
     * 账号：Account_ID,用来唯一标识一个账户的ID；长度20位
     * 格式说明：2088 XX2 XXXXXXXX 0 156
     * 前四位2088，代表**巴巴；
     * XX2代表账户类型为个人,XX1为公司， XX3位内部；
     * XXXXXXXX这9位代表账号序列号，156代表币种为人民币；
     * 目前某付宝账号的前16位与该会员ID号相同，若中间9位代表账号序列用尽，可是使用XX2的前两位作为扩展
     *
     * @param accClassify 账户分类.
     * @return 账户号.
     */
    public static String createAccNo(final AccClassifyEnum accClassify) {

        if (AccClassifyEnum.PERSON == accClassify) {
            return StrUtil.concat(false, "7", RandomUtil.randomNumbers(15), "156");
        } else if (AccClassifyEnum.ORG == accClassify) {
            return StrUtil.concat(false, "8", RandomUtil.randomNumbers(15), "156");
        } else if (AccClassifyEnum.INTERNAL == accClassify) {
            return StrUtil.concat(false, "9", RandomUtil.randomNumbers(15), "156");
        } else {
            UcException.throwBizFailException(ResponseCodeEnum.PARAM_VERIFY_FAIL);
        }

        return null;
    }
}
