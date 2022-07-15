package paydemo.uc.manager.model;

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
public class UserSecQuestInfoBO{

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
