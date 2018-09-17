package star.myblog.common;

/**
 * TODO 在开发过程中，有时候会需要使用错误码+错误信息的形式，
 * 来返回某些业务操作的错误结果信息，来代替效率较低的异常传递。
 * 这样就需要封装一个统一的Result model作为返回值
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午1:59:00
 * @project myblog
 *
 */
public class ResultBuilderModel {
	
	/**
	 * 创建操作成功ReturnModel 
	 * @param data 操作成功后的数据
	 * @return
	 */
	public static ResultModel Success(Object data) {
		ResultModel success = new ResultModel();
		success.setData(data);
		success.setResult(true);
		return success;
	}
	
	/**
	 * 创建操作失败ReturnModel
	 * @param reason 操作失败的原因
	 * @return
	 */
	public static ResultModel Failure(String reason) {
		ResultModel failure = new ResultModel();
		failure.setReason(reason);
		failure.setResult(false);
		return failure;
	}
}
