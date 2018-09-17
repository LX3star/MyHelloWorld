package star.myblog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class WebBaseConf {
	@Value("#{webappProperties.path}")
	private String path;
	
	@Bean(name="appPath")
	public String path() {
		if(this.path == null || this.path.trim().equals("/")) {
			return "";
		}
		return this.path.trim();
	}
}
