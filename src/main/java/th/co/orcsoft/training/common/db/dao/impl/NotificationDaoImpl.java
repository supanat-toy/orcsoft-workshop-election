package th.co.orcsoft.training.common.db.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.NotificationDao;
import th.co.orcsoft.training.model.db.NotificationModel;
import th.co.orcsoft.training.model.enums.UserRoleEnum;

@Repository
public class NotificationDaoImpl extends AbsCorDao implements NotificationDao {

	@Override
	public List<NotificationModel> getNotificationList(boolean isOfficer) {
		UserRoleEnum userRoleEnum = isOfficer ? UserRoleEnum.officer : UserRoleEnum.center;

		String sql = String.format("SELECT * FROM notification WHERE RespPosn = '%s'", userRoleEnum.getValue());

		List<NotificationModel> list = namedParameterJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<NotificationModel>(NotificationModel.class));
		return list;
	}

}
