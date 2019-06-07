package th.co.orcsoft.training.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	@Autowired
	private ApplicationConfig applicationConfig;

	@Bean("dataSourceCor")
	public DataSource dataSourceCor() {
		DriverManagerDataSource bs = new DriverManagerDataSource();
		bs.setDriverClassName(applicationConfig.getDatasourceDriverClassName());
		bs.setUrl(applicationConfig.getDatasourceUrl());
		bs.setUsername(applicationConfig.getDatasourceUsername());
		bs.setPassword(applicationConfig.getDatasourcePassword());
		return bs;
	}

	@Bean("namedParameterJdbcTemplateCor")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplateCor() {
		return new NamedParameterJdbcTemplate(dataSourceCor());
	}

	@Bean("dataSourceTransactionManagerCor")
	public DataSourceTransactionManager dataSourceTransactionManagerCor() {
		return new DataSourceTransactionManager(dataSourceCor());
	}

}
