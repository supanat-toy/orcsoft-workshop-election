package th.co.orcsoft.training.common.db.dao.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.CenterDao;
import th.co.orcsoft.training.model.db.VoteModel;

@Repository
public class CenterDaoImpl extends AbsCorDao implements CenterDao {

	
	@Override
	public List<VoteModel> getRequestedApprovals() {
		String sql = "Select * From Vote Where AprvFlag is null and UpdFlag = :UpdFlag and UpdAprvFlag is null Order by updDTM";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("UpdFlag", true);
		
		List<VoteModel> requestedConfirmations = new ArrayList<VoteModel>();
		
		try {
			requestedConfirmations = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getRequestedApprovals() -> " + e.toString());
		}
		
		return requestedConfirmations;
	}

	@Override
	public List<VoteModel> getRequestedModifications() {
		String sql = "Select * From VOTE Where AprvFlag = :AprvFlag and UpdFlag = :UpdFlag and UpdAprvFlag is null Order by updDTM";
		
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
	public boolean replyRequestedApproval(int districtId, boolean isApproved, String approvedBy) {
		
		String sql = "Update Vote Set AprvFlag = :AprvFlag, AprvBy = :AprvBy Where DistID = :DistID";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("AprvFlag", isApproved);
		paramMap.put("AprvBy", approvedBy);
		paramMap.put("DistID", districtId);
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - replyRequestedApproval() for districtId = " + districtId + ", isApproved = " + isApproved);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - replyRequestedApproval() -> " + e.toString());
		}
		return false;
	}

	@Override
	public boolean replyRequestedModification(int districtId, boolean isApproved,String updatedApprovedBy) {
		
		String sql = "Update Vote Set UpdAprvFlag = :UpdAprvFlag, UpdAprvBy = :UpdAprvBy Where DistID = :DistID";
		
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
