package paydemo.uc.dao.dbmodel;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther YDXiaa
 * <p>
 * 用户密保问题.
 */
@Getter
@Setter
@ToString
@TableName("T_USER_SEC_QUEST_INFO")
public class UserSecQuestInfoDO extends BaseDO {

    /**
     * 用户号.
     */
    private String userNo;

    /**
     * 密保问题顺序.
     */
    private int seq;

    /**
     * 密保问题.
     */
    private String secQuestion;

    /**
     * 密保问题答案.
     */
    private String secQuestionAnswer;


}
