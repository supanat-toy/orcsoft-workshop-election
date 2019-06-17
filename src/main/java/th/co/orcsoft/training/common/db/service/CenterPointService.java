package th.co.orcsoft.training.common.db.service;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterPointService {
	public List<VoteModel> getRequestedConfirmations();

	public List<VoteModel> getRequestedModifications();

	public void replyRequestedConfirmations(int districtId, boolean isApproved, String updatedBy);

	public void replyRequestedModifications(int districtId, boolean isApproved, String updateBy);
}
