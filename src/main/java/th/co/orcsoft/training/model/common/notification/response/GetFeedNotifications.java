package th.co.orcsoft.training.model.common.notification.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.NotificationModel;

public class GetFeedNotifications extends AbsResponseModel {

	private List<NotificationModel> notifications;

	public List<NotificationModel> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationModel> notifications) {
		this.notifications = notifications;
	}
}
