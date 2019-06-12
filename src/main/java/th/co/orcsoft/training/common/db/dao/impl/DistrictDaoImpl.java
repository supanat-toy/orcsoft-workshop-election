package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.dao.DistrictDao;
import th.co.orcsoft.training.model.db.ProvinceModel;
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
	public void requestToModifiedElectionResult(int districtId,String updBy) {

		
		String sql = "UPDATE VOTE SET UPDFLAG = 'TRUE' , UPDBY = '"+updBy+"' WHERE DISTID = "+districtId+" ";
        SqlParameterSource namedParameters = new MapSqlParameterSource();
        int status = namedParameterJdbcTemplate.update(sql, namedParameters); 
        if(status != 0){
            System.out.println("Vote data updated for disId = " + districtId);
        }else{
            System.out.println("No Vote found with distNum = " + districtId);
        }
		
	
		
	}

	@Override
	public List<VoteModel> getResultRequestModifications() {
		String sql = "SELECT * FROM Vote WHERE APRVFLAG = 'FALSE' AND UPDFLAG IS NULL AND UPDAPRVFLAG IS NULL";
		List<VoteModel> resultRequestModi = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return resultRequestModi;
		
	}

}
