package th.co.orcsoft.training.common.db.service;

import java.util.List;

import th.co.orcsoft.training.model.db.NotificationModel;

public interface NotificationService {
	public List<NotificationModel> getNotificationList(boolean isOfficer);
}
