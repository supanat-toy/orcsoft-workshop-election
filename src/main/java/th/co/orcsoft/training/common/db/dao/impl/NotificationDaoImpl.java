package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.dao.NotificationDao;
import th.co.orcsoft.training.model.db.NotificationModel;
import th.co.orcsoft.training.model.db.PartyModel;

@Repository
public class NotificationDaoImpl extends AbsCorDao implements NotificationDao {

	@Override
	public List<NotificationModel> getNotificationList(String userId) {
		String sql = "SELECT * From notification";
		List<NotificationModel> list = namedParameterJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<NotificationModel>(NotificationModel.class));
		return list;
	}

}
