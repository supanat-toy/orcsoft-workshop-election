package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.dao.DistrictDao;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class DistrictDaoImpl extends AbsCorDao implements DistrictDao {

	@Override
	public VoteModel getElectionDistrictInfo(int districtId) {
		String sql = String.format("SELECT TOP 1 * FROM VOTE WHERE DistID = '%s'", districtId);
		List<VoteModel> voteList = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));

		if (voteList.size() > 0) {
			return voteList.get(0) ;
		}
		return null;
	}

	@Override
	public void createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, int badVote, int voteNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, int badVote, int voteNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestToModifiedElectionResult(int districtId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VoteModel> getResultRequestModifications() {
		// TODO Auto-generated method stub
		return null;
	}

}
