package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.VoteModel;

public interface DistrictDao {
	public VoteModel getElectionDistrictInfo(int districtId);

	public void updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote,
			int pty3Id, int pty3Vote, double badVote, double voteNo, String UpdBy);

	public int createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote,
			int pty3Id, int pty3Vote, double badVote, double voteNo, String updBy);

	public void requestToModifiedElectionResult(int districtId, String updBy);

	public List<VoteModel> getResultRequestModifications();
}
