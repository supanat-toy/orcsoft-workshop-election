package th.co.orcsoft.training.common.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbsCorDao {
	@Autowired
	@Qualifier("namedParameterJdbcTemplateCor")
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
