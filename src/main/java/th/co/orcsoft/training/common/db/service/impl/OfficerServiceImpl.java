package th.co.orcsoft.training.common.db.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.OfficerDao;
import th.co.orcsoft.training.common.db.service.OfficerService;
import th.co.orcsoft.training.model.db.VoteModel;

@Service
public class OfficerServiceImpl implements OfficerService {

	@Autowired
	private OfficerDao officerDao;
	
	@Override
	public VoteModel getElectionDistrictInfo(int districtId) {
		return officerDao.getElectionDistrictInfo(districtId);
	}

	@Override
	public boolean createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, double badVote, double voteNo, String updBy) {
		return officerDao.createElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote, badVote, voteNo, updBy);
	}

	@Override
	public boolean updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, double badVote, double voteNo, String UpdBy) {
		return officerDao.updateElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote, badVote, voteNo, UpdBy);
	}

	@Override
	public boolean requestToModifiedElectionResult(int districtId,String updBy) {
		return officerDao.requestToModifiedElectionResult(districtId, updBy);
	}

	@Override
	public List<VoteModel> getApprovedModifications() {
		return officerDao.getApprovedModifications(); 
	}

	@Override
	public List<VoteModel> getPendingRequestedApproval() {
		return officerDao.getPendingRequestedApproval();
	}

	@Override
	public ArrayList<Integer> getNotApprovedDistrictsByProvince(int provinceId) {
		return officerDao.getNotApprovedDistrictsByProvince(provinceId);
	}
}
