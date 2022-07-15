package paydemo.uc.facade.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther YDXiaa
 * <p>
 * 用户密保问题.
 */
@Data
public class UserSecQuestInfoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
