package th.co.orcsoft.training.common.db.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		String sql = "Select * From notification Where RespPosn = :RespPosn";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("RespPosn", userRoleEnum.getValue());
		
		List<NotificationModel> notifications = new ArrayList<NotificationModel>();
		
		try {
			notifications = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<NotificationModel>(NotificationModel.class));
		} catch (Exception e) {
			System.out.println("catch - getNotificationList() -> " + e.toString());
		}
		
		return notifications;
	}

}
