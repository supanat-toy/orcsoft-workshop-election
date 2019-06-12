package th.co.orcsoft.training.common.db.service;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface CenterPointService {
	public List<VoteModel> getRequestedConfirmations();
	public List<VoteModel> getRequestedModifications();
	public void replyRequestedConfirmations(int id, boolean isApproved);
	public void replyRequestedModifications(int id, boolean isApproved);
}
