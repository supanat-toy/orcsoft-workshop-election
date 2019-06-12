package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.CenterPointDao;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class CenterPointDaoImpl extends AbsCorDao implements CenterPointDao {

	
	@Override
	public List<VoteModel> getRequestedConfirmations() {
		String sql = "SELECT * FROM VOTE WHERE AprvFlag is null AND UpdFlag = 'true' AND UpdAprvFlag is null";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return list;
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		String sql = "SELECT * FROM VOTE WHERE AprvFlag = 'true' "
				+ "AND UpdFlag = 'true'"
				+ "AND UpdAprvFlag is null";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return list;
	}

	@Override
	public void replyRequestedConfirmations(int id, boolean isApproved) {
		if(isApproved) {
			String sql = "UPDATE VOTE SET AprvFlag = 'true' , AprvBy =  , UpdBy is null , UpdFlag is null , UpdAprvFlag is null , UpdAprvBy is null WHERE DistID = id";
		}
		else {
			String sql = "UPDATE VOTE SET AprvFlag = 'false' , AprvBy is null , UpdBy is null , UpdFlag is null , UpdAprvFlag is null , UpdAprvBy is null WHERE DistID = id";
			
		}
			
	}

	@Override
	public void replyRequestedModifications(int id, boolean isApproved) {
		
	}

}
