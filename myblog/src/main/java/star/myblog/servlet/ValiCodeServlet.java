package star.myblog.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * TODO 生成验证码的serlvet
 * 
 * @author huangzq
 * @mailbox 1375529585@qq.com
 * @date 下午1:52:00
 * @project myblog
 *
 */
public class ValiCodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValiCodeServlet() {
		super();
	}

	public void dastroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}

	/**
	 * 获取随机生成的颜色
	 * 
	 * @param s
	 * @param e
	 * @return
	 */
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255) {
			s = 255;
		}
		if (e > 255) {
			e = 255;
		}
		int r, g, b;
		r = s + random.nextInt(e - s);
		g = s + random.nextInt(e - s);
		b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 下面3条记录是关闭客户端浏览器的缓冲区
		// 这3条语句都可以关闭浏览器的缓冲区，但是由于浏览器的版本不同，对这3条语句的支持也不同
		// 因此，为了保险起见，同时使用这3条语句来关闭浏览器的缓冲区
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);

		// 指定生成的响应图片,一定不能缺少这句话,否则错误.
		response.setContentType("image/jpeg");

		// 指定生成验证码的宽度和高度
		int width = 86, height = 22;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 创造画笔
		Graphics gPen = image.getGraphics();

		Random random = new Random();

		// 定义字体样式
		Font mfont = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		gPen.setColor(getRandColor(200, 250));
		// 绘制背景
		gPen.fillRect(0, 0, width, height);
		// 设置字体
		gPen.setFont(mfont);
		gPen.setColor(getRandColor(180, 200));

		StringBuffer sb = new StringBuffer();
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int index, len = ch.length;
		for (int i = 0; i < 4; i++) {
			index = random.nextInt(len);
			gPen.drawString("" + ch[index], (i * 15) + 3, 18);// 写什么数字，在图片的什么位置画
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(image, "JPG", response.getOutputStream());
	}
}
