package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.UserLevelInfoDO;
import paydemo.uc.dao.mapper.UserLevelInfoMapper;

/**
 * @auther YDXiaa
 * <p>
 * 用户等级信息.
 */
@Repository
public class UserLevelInfoManager {


    @Autowired
    private UserLevelInfoMapper userLevelInfoMapper;


    /**
     * 查询用户等级信息.
     *
     * @param userNo 用户编号.
     * @return 用户等级信息.
     */
    public UserLevelInfoDO queryUserLevelInfo(String userNo) {

        LambdaQueryWrapper<UserLevelInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserLevelInfoDO::getUserNo, userNo);

        return userLevelInfoMapper.selectOne(queryWrapper);
    }
}
