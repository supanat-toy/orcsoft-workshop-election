package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.CenterDao;
import th.co.orcsoft.training.common.db.service.CenterService;
import th.co.orcsoft.training.model.db.VoteModel;

@Service
public class CenterServiceImpl implements CenterService {

	@Autowired
	private CenterDao centerDao;
	
	@Override
	public List<VoteModel> getRequestedApprovals() {
		return centerDao.getRequestedApprovals();
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		return centerDao.getRequestedModifications();
	}

	@Override
	public boolean replyRequestedApproval(int provinceID, boolean isApproved, String updatedBy) {
		return centerDao.replyRequestedApproval(provinceID, isApproved, updatedBy);
	}

	@Override
	public boolean replyRequestedModification(int provinceID, boolean isApproved,String updateBy) {
		return centerDao.replyRequestedModification(provinceID, isApproved,updateBy);
	}

}
