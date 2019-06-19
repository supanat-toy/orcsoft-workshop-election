package th.co.orcsoft.training.model.common.notification.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.NotificationModel;

@Data
public class GetFeedNotifications extends AbsResponseModel {

	private List<NotificationModel> notifications;
}
