package star.myblog.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * TODO 密保问题的枚举类
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午3:10:57
 * @project myblog
 *
 */
public enum PaswordSafeEnum {
	Question1("你最喜欢的颜色是？", 1),
	Question2("你最喜欢的水果是？", 2),
	Question3("你的星星是？", 3),
	Question4("你的母校是？", 4),
	Question5("你的生日是？", 5);
	
	// 成员变量
	private String questionStr;
	// 问题类型编号
	private Integer type;
	
	// 构造方法 
	private PaswordSafeEnum(String questionStr, Integer type) {
		this.questionStr = questionStr;
		this.type = type;
	}
	/**
	 * 根据编号获得问题
	 * @param type 编号
	 * @return 问题
	 */
	public static String getQuestionStrByType(Integer type) {
		for (PaswordSafeEnum pasWordEnum : PaswordSafeEnum.values()) {
			Integer nums = pasWordEnum.getType();
			if (nums.equals(type)) {
				return pasWordEnum.getQuestionStr();
			}
		}
		return null;
	}
	/**
	 * 根据问题获取编号
	 * @param question 问题
	 * @return 编号
	 */
	public static Integer getTypeByQuestionStr(String question) {
		
		for (PaswordSafeEnum pasWordEnum : PaswordSafeEnum.values()) {
			String questionString = pasWordEnum.getQuestionStr();
			if (questionString.equals(question)) {
				return pasWordEnum.getType();
			}
		}
		return null;
		
	}
	/**
	 * 根据编号获取对应的PaswordSafeEnum
	 * @param type 编号
	 * @return
	 */
	public static List<PaswordSafeEnum> getPaswordSafeEnum(Integer type){
		List<PaswordSafeEnum> enumList = new ArrayList<>();
		for (PaswordSafeEnum pasWordEnum : PaswordSafeEnum.values()) {
			Integer nums = pasWordEnum.getType();
			if (type.equals(nums)) {
				enumList.add(pasWordEnum);
			}
		}
		return enumList;
	}
	
	// get set 方法
	public String getQuestionStr() {
		return questionStr;
	}

	public void setQuestionStr(String questionStr) {
		this.questionStr = questionStr;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
