package star.myblog.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	/**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Date convert(String source) {
		if(source == null || source.length() == 0) {
			return null;
		}
		SimpleDateFormat dateSdf;
		if(source.length() == 10) {
			dateSdf = new SimpleDateFormat("yyyy-MM-dd");
		}else {
			dateSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		
		try {
			Date date = dateSdf.parse(source);
			return date;
		}catch (ParseException e) {
			logger.info("日期转换失败,格式类型必须为yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss");
			return null;
		}
		
	}
}

