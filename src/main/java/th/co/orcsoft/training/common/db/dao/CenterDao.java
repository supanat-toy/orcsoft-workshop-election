package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterDao {
	public List<VoteModel> getRequestedApprovals();
	public List<VoteModel> getRequestedModifications();
	public boolean replyRequestedModification(int districtId, boolean isApproved, String approvedBy);
	public boolean replyRequestedApproval(int districtId, boolean isApproved, String updatedBy);
}
