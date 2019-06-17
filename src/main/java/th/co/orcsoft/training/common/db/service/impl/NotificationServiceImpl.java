package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.NotificationDao;
import th.co.orcsoft.training.common.db.service.NotificationService;
import th.co.orcsoft.training.model.db.NotificationModel;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	public NotificationDao notificationDao;

	@Override
	public List<NotificationModel> getNotificationList(boolean isOfficer) {
		return notificationDao.getNotificationList(isOfficer);
	}

}
