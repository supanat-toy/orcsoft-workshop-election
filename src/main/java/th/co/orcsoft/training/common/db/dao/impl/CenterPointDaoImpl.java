package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.CenterPointDao;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class CenterPointDaoImpl extends AbsCorDao implements CenterPointDao {

	
	@Override
	public List<VoteModel> getRequestedConfirmations() {
		String sql = "SELECT * FROM Vote WHERE AprvFlag is null AND UpdFlag = 'true' AND UpdAprvFlag is null ";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		return list;
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		String sql = "SELECT * FROM VOTE WHERE AprvFlag = 'true' "
				+ "AND UpdFlag = 'true'"
				+ "AND UpdAprvFlag is null ";
		List<VoteModel> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		System.out.println(list);
		return list;
	}

	@Override
	public void replyRequestedConfirmations(int provinceID, boolean isApproved, String updatedBy) {
		if(isApproved) {
			String sql = "UPDATE VOTE SET AprvFlag = 'true' , AprvBy = '"+updatedBy+"' WHERE DistID = "+provinceID+"";
			SqlParameterSource namedParameters = new MapSqlParameterSource();
			int status = namedParameterJdbcTemplate.update(sql, namedParameters); 
	        if(status != 0){
	            System.out.println(" data updated for distID "+provinceID);
	        }else{
	            System.out.println(" Not data update ");
	        }
		}
		else {
			String sql = "UPDATE VOTE SET AprvFlag = 'false' , AprvBy = '"+updatedBy+"' WHERE DistID = "+provinceID+"";
			SqlParameterSource namedParameters = new MapSqlParameterSource();
			int status = namedParameterJdbcTemplate.update(sql, namedParameters); 
	        if(status != 0){
	            System.out.println(" data updated for distID "+provinceID);
	        }else{
	            System.out.println(" Not data update ");
	        }
		}
	}

	@Override
	public void replyRequestedModifications(int provinceID, boolean isApproved,String updateBy) {
		if (isApproved = true) {
			String sql = "UPDATE VOTE SET UpdAprvBy = '"+updateBy+"'"
					+ ", updAprvFlag ='true' "
					+ "WHERE DistID = "+provinceID+" "; 
			
			SqlParameterSource namedParameters = new MapSqlParameterSource();
			int status =  namedParameterJdbcTemplate.update(sql, namedParameters);
				if(status != 0){
					System.out.println("data updated for distId"+provinceID);
				}else{
					System.out.println("Not data updated for distId"+provinceID);
				}		
				
		}else {
			String sql = "UPDATE VOTE SET UpdAprvBy = '"+updateBy+"'"
					+ ", UpdAprvFlag = 'false' "
					+ "WHERE DistID = "+provinceID+" ";
			
			SqlParameterSource namedParameters = new MapSqlParameterSource();
			int status =  namedParameterJdbcTemplate.update(sql, namedParameters);
			 	if(status != 0){
			 		System.out.println("data updated for distId"+provinceID);
				}else{
					System.out.println("Not data updated for distId"+provinceID);
				}			
			 	
		}
	}

}
