package th.co.orcsoft.training.common.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public abstract class AbsCorService {
	@Autowired
	@Qualifier("dataSourceTransactionManagerCor")
	protected DataSourceTransactionManager transactionManager;

}
