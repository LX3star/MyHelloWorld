package star.myblog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import star.myblog.common.FMView;

/**
 * 测试echarts地图
 * TODO
 * @author huangzq
 * @time 2018年9月17日
 * @project_name myblog
 * @mailbox 1375529585@qq.com
 */
@Controller
@RequestMapping(value = "myecharts")
public class EchartsMapController {

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public FMView getPage(HttpServletRequest request) {
		FMView page = new FMView("echartsMap");
		return page;
	}
}
