package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.Map;
import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.dao.DistrictDao;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;
import java.util.HashMap;

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
	public int createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, double badVote, double voteNo, String updBy) {
		
		String sql = "INSERT INTO Vote (PrvID, DistNum, Pty1_ID, Pty1Vote, Pty2_ID, Pty2Vote, Pty3_ID, Pty3Vote, BadVote, VoteNo, UpdFlag, UpdBy) Values (:PrvID, :DistNum, :Pty1_ID, :Pty1Vote, :Pty2_ID, :Pty2Vote, :Pty3_ID, :Pty3Vote, :BadVote, :VoteNo, :UpdFlag, :UpdBy)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("PrvID", prvId);
		paramMap.put("DistNum", distNum);
		paramMap.put("Pty1_ID", pty1Id);
		paramMap.put("Pty1Vote", pty1Vote);
		paramMap.put("Pty2_ID", pty2Id);
		paramMap.put("Pty2Vote", pty2Vote);
		paramMap.put("Pty3_ID", pty3Id);
		paramMap.put("Pty3Vote", pty3Vote);
		paramMap.put("BadVote", badVote);
		paramMap.put("VoteNo", voteNo);
		paramMap.put("UpdFlag", true);
		paramMap.put("UpdBy", updBy);
		
		return namedParameterJdbcTemplate.update(sql, paramMap);  
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
