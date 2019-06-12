package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.NotificationModel;

public interface NotificationDao {

	public List<NotificationModel> getNotificationList(String userId);
	
}
