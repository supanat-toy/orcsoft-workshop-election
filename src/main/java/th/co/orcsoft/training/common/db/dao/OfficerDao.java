package th.co.orcsoft.training.common.db.dao;

import java.util.ArrayList;
import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface OfficerDao {
	public VoteModel getElectionDistrictInfo(int districtId);
	public boolean updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id, int pty3Vote, double badVote, double voteNo, String updBy);
	public boolean createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id, int pty3Vote, double badVote, double voteNo, String updBy);
	public boolean requestToModifiedElectionResult(int districtId, String updBy);
	public List<VoteModel> getApprovedModifications();
	public List<VoteModel> getPendingRequestedApproval();
	public ArrayList<Integer> getNotApprovedDistrictsByProvince(int provinceId);
}
