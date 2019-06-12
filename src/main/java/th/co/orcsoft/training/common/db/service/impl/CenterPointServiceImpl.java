package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.CenterPointDao;
import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.common.db.service.CenterPointService;
import th.co.orcsoft.training.model.db.VoteModel;

@Service
public class CenterPointServiceImpl implements CenterPointService {

	@Autowired
	private CenterPointDao centerPointDao;
	
	@Override
	public List<VoteModel> getRequestedConfirmations() {
		return centerPointDao.getRequestedConfirmations();
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		return centerPointDao.getRequestedModifications();
	}

	@Override
	public void replyRequestedConfirmations(int id, boolean isApproved, String updatedBy) {
		centerPointDao.replyRequestedConfirmations(id, isApproved, updatedBy);
	}

	@Override
	public void replyRequestedModifications(int id, boolean isApproved,String updateBy) {
		centerPointDao.replyRequestedModifications(id, isApproved,updateBy);
	}

}
