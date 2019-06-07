package th.co.orcsoft.training.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class ApplicationConfig {
	// Database COR
	@Value("${spring.datasource.driver-class-name}")
	private String datasourceDriverClassName;
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	public String getDatasourceDriverClassName() {
		return datasourceDriverClassName;
	}

	public void setDatasourceDriverClassName(String datasourceDriverClassName) {
		this.datasourceDriverClassName = datasourceDriverClassName;
	}

	public String getDatasourceUrl() {
		return datasourceUrl;
	}

	public void setDatasourceUrl(String datasourceUrl) {
		this.datasourceUrl = datasourceUrl;
	}

	public String getDatasourceUsername() {
		return datasourceUsername;
	}

	public void setDatasourceUsername(String datasourceUsername) {
		this.datasourceUsername = datasourceUsername;
	}

	public String getDatasourcePassword() {
		return datasourcePassword;
	}

	public void setDatasourcePassword(String datasourcePassword) {
		this.datasourcePassword = datasourcePassword;
	}

}
