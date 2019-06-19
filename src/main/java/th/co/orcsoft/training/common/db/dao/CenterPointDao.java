package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterPointDao {
	public List<VoteModel> getRequestedConfirmations();
	public List<VoteModel> getRequestedModifications();
	public boolean replyRequestedModifications(int districtId, boolean isApproved, String approvedBy);
	public boolean replyRequestedConfirmations(int districtId, boolean isApproved, String updatedBy);
}
