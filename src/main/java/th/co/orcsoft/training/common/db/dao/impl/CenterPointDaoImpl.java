package th.co.orcsoft.training.common.db.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.CenterPointDao;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class CenterPointDaoImpl extends AbsCorDao implements CenterPointDao {

	
	@Override
	public List<VoteModel> getRequestedConfirmations() {
		String sql = "SELECT * FROM Vote WHERE AprvFlag is null AND UpdFlag = :UpdFlag AND UpdAprvFlag is null ";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("UpdFlag", true);
		
		List<VoteModel> requestedConfirmations = new ArrayList<VoteModel>();
		
		try {
			requestedConfirmations = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getRequestedConfirmations() -> " + e.toString());
		}
		
		return requestedConfirmations;
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		String sql = "SELECT * FROM VOTE WHERE AprvFlag = :AprvFlag AND UpdFlag = :UpdFlag AND UpdAprvFlag is null";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("AprvFlag", true);
		paramMap.put("UpdFlag", true);
		
		List<VoteModel> requestedModifications = new ArrayList<VoteModel>();
		try {
			requestedModifications = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getRequestedModifications() -> " + e.toString());
		}
		
		return requestedModifications;
	}

	@Override
	public boolean replyRequestedConfirmations(int districtId, boolean isApproved, String approvedBy) {
		
		String sql = "UPDATE VOTE SET AprvFlag = :AprvFlag , AprvBy = :AprvBy WHERE DistID = :DistID";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("AprvFlag", isApproved);
		paramMap.put("AprvBy", approvedBy);
		paramMap.put("DistID", districtId);
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - replyRequestedConfirmations() for districtId = " + districtId + ", isApproved = " + isApproved);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - replyRequestedConfirmations() -> " + e.toString());
		}
		return false;
	}

	@Override
	public boolean replyRequestedModifications(int districtId, boolean isApproved,String updatedApprovedBy) {
		
		String sql = "UPDATE VOTE SET UpdAprvBy = :AprvBy WHERE DistID = :DistID";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("UpdAprvFlag", isApproved);
		paramMap.put("UpdAprvBy", updatedApprovedBy);
		paramMap.put("DistID", districtId);
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - replyRequestedModifications() for districtId = " + districtId + ", isApproved = " + isApproved);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - replyRequestedModifications() -> " + e.toString());
		}
		return false;
	}

}
