package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterPointDao {
	public List<VoteModel> getRequestedConfirmations();
	public List<VoteModel> getRequestedModifications();
	public void replyRequestedConfirmations(int id, boolean isApproved, String updatedBy);
	public void replyRequestedModifications(int id, boolean isApproved, String updatedBy);
}
