package th.co.orcsoft.training.common.db.service;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterService {
	public List<VoteModel> getRequestedApprovals();
	public List<VoteModel> getRequestedModifications();
	public boolean replyRequestedApproval(int districtId, boolean isApproved, String updatedBy);
	public boolean replyRequestedModification(int districtId, boolean isApproved,String updateBy);
}
