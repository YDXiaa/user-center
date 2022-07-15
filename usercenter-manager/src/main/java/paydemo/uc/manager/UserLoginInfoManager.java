package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.UserLoginInfoDO;
import paydemo.uc.dao.mapper.UserLoginInfoMapper;
import paydemo.util.UsableEnum;

import java.util.List;

/**
 * @auther YDXiaa
 * <p>
 * 用户登录信息.
 */
@Repository
public class UserLoginInfoManager {

    @Autowired
    private UserLoginInfoMapper userLoginInfoMapper;


    /**
     * 查询登录号.
     *
     * @param loginNo        登录号.
     * @param loginNoType    登录号类型.
     * @param loginNoChannel 登录号渠道.
     * @return 用户登录号信息.
     */
    public UserLoginInfoDO queryLoginNo(String loginNo, String loginNoType, String loginNoChannel) {

        LambdaQueryWrapper<UserLoginInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserLoginInfoDO::getLoginNo, loginNo)
                .eq(UserLoginInfoDO::getLoginNoType, loginNoType)
                .eq(UserLoginInfoDO::getLoginNoChannel, loginNoChannel)
                .eq(UserLoginInfoDO::getLoginNoStatus, UsableEnum.NORMAL);

        return userLoginInfoMapper.selectOne(queryWrapper);
    }

    /**
     * 查询用户编号下所有登录信息.
     *
     * @param userNo 用户编号.
     * @return 用户所有登录信息.
     */
    public List<UserLoginInfoDO> queryUserLoginInfoByUserNo(String userNo) {

        LambdaQueryWrapper<UserLoginInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserLoginInfoDO::getUserNo, userNo);

        return userLoginInfoMapper.selectList(queryWrapper);
    }
}
