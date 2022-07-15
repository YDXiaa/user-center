package paydemo.uc.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auther YDXiaa
 * <p>
 * 操作角色(RBAC权限模型-角色).
 * <p>
 * 银行系统中用户角色是根据企业业务需求设置的不同用户，分别有管理员、操作员、复核员，不同的角色有不同的权限，能够执行不同的业务操作。
 * 开户成功后成为管理员。管理员可以设置操作员和复核员,操作流程是“经办-复核”的方式完成，操作员提交交易订单，由复核员复核后生效，以保证业务操作的安全
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    /**
     * 主要用户.
     */
    PRIMARY("PRIMARY", "主要用户"),
    ;

    /**
     * 用户角色编码.
     */
    private final String userRoleCode;

    /**
     * 用户角色描述.
     */
    private final String userRoleDesc;

}
