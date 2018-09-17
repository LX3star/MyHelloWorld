package star.myblog.common;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * TODO
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 上午10:38:43
 * @project myblog
 *
 */
public class FMView extends ModelAndView{
	public FMView(String viewName) {
		super(viewName);
		this.addObject("path", SystemParameterConstant.WEBAPP_PATH);
	}
}
