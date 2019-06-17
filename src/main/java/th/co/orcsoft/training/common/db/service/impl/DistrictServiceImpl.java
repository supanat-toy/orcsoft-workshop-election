package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.DistrictDao;
import th.co.orcsoft.training.common.db.service.DistrictService;
import th.co.orcsoft.training.model.db.VoteModel;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDao districtDao;

	@Override
	public VoteModel getElectionDistrictInfo(int districtId) {
		return districtDao.getElectionDistrictInfo(districtId);
	}

	@Override
	public void createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote,
			int pty3Id, int pty3Vote, double badVote, double voteNo, String updBy) {
		districtDao.createElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote,
				badVote, voteNo, updBy);
	}

	@Override
	public void updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote,
			int pty3Id, int pty3Vote, double badVote, double voteNo, String UpdBy) {
		districtDao.updateElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote,
				badVote, voteNo, UpdBy);
	}

	@Override
	public void requestToModifiedElectionResult(int districtId, String updBy) {

		districtDao.requestToModifiedElectionResult(districtId, updBy);
	}

	@Override
	public List<VoteModel> getResultRequestModifications() {
		List<VoteModel> result = districtDao.getResultRequestModifications();
		System.out.print(result);
		return result;
	}

}
