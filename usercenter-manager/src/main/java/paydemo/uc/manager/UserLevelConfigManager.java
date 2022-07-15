package paydemo.uc.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import paydemo.uc.dao.dbmodel.UserLevelConfigDO;
import paydemo.uc.dao.mapper.UserLevelConfigMapper;

/**
 * @auther YDXiaa
 * <p>
 * 用户等级配置表.
 */
@Repository
public class UserLevelConfigManager {

    @Autowired
    private UserLevelConfigMapper userLevelConfigMapper;


    /**
     * 添加用户等级配置.
     *
     * @param userLevelConfigDO 用户等级配置.
     * @return 添加结果.
     */
    public boolean addUserLevelConfig(UserLevelConfigDO userLevelConfigDO) {
        return 1 == userLevelConfigMapper.insert(userLevelConfigDO);
    }

    /**
     * 查询满足用户等级配置分数配置信息.
     *
     * @param levelScore 等级分数.
     * @return 用户等级配置信息.
     */
    public UserLevelConfigDO queryUserLevelConfig(long levelScore) {

        LambdaQueryWrapper<UserLevelConfigDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserLevelConfigDO::getLevelStartScore, levelScore)
                .ge(UserLevelConfigDO::getLevelEndScore, levelScore);

        return userLevelConfigMapper.selectOne(queryWrapper);
    }

}
