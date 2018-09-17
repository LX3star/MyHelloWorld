package star.myblog.common;

/**
 * 
 * TODO 本项目自定义的异常
 * 
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 2018年9月10日 下午2:42:41
 * @project myblog
 *
 */
public class MyblogException extends Exception {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	public MyblogException(String message) {
		super(message);
	}

}
