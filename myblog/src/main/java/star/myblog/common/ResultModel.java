package star.myblog.common;

/**
 * 业务结果封装类 TODO
 * 
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午2:01:57
 * @project myblog
 *
 */
public class ResultModel {
	// 操作结果成功与否 真表示成功
	private boolean result;
	// 失败原因
	private String reason;
	// 操作成功的数据
	private Object data;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
