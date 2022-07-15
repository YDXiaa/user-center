package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.UserInfoDO;
import paydemo.uc.dao.mapper.UserInfoMapper;

/**
 * @auther YDXiaa
 * <p>
 * 用户信息.
 */
@Repository
public class UserInfoManager {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询用户信息.
     *
     * @param userNo 用户编号.
     * @return 用户信息.
     */
    public UserInfoDO queryUserInfo(String userNo) {

        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfoDO::getUserNo, userNo)
                .ne(UserInfoDO::getUserStatus, "CLOSE");

        return userInfoMapper.selectOne(queryWrapper);
    }
}
