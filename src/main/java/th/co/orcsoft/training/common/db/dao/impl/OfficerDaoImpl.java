package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.Map;
import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.OfficerDao;
import th.co.orcsoft.training.model.db.ProvinceDistrictVote;
import th.co.orcsoft.training.model.db.VoteModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@Repository
public class OfficerDaoImpl extends AbsCorDao implements OfficerDao {

	@Override
	public VoteModel getElectionDistrictInfo(int districtId) {
		String sql = "Select * From Vote Where DistID = :DistID";
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource("DistID", districtId);

		VoteModel vote = null;
		try {
			vote = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getElectionDistrictInfo() -> " + e.toString());
		}
		
		return vote;
	}

	@Override
	public boolean createElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, double badVote, double voteNo, String updBy) {
		
		String sql = "Insert into Vote (PrvID, DistNum, Pty1_ID, Pty1Vote, Pty2_ID, Pty2Vote, Pty3_ID, Pty3Vote, BadVote, VoteNo, UpdFlag, UpdBy) Values (:PrvID, :DistNum, :Pty1_ID, :Pty1Vote, :Pty2_ID, :Pty2Vote, :Pty3_ID, :Pty3Vote, :BadVote, :VoteNo, :UpdFlag, :UpdBy)";

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
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - createElectionDistrict() for prvId = " + prvId + ", distNum = " + distNum);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - createElectionDistrict() -> " + e.toString());
		}
		return false;
	}
	// https://www.programcreek.com/java-api-examples/?class=org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate&method=update
	@Override
	public boolean updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id,
			int pty3Vote, double badVote, double voteNo, String updBy) {
		
		String sql = "Update Vote SET pty1_Id = :Pty1_ID, pty1Vote = :Pty1Vote, pty2_Id = :Pty2_ID, pty2Vote = :Pty2Vote, pty3_Id = :Pty3_ID, pty3Vote = :Pty3Vote, " + 
					 "badVote = :BadVote, voteNo = :VoteNo, updFlag = :UpdFlag, updBy = :UpdBy " +
					 "Where prvId = :PrvID AND distNum = :DistNum ";
		
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
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - updateElectionDistrict() for prvId = " + prvId + ", distNum = " + distNum);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - updateElectionDistrict() -> " + e.toString());
		}
		return false;
	}

	@Override
	public boolean requestToModifiedElectionResult(int districtId,String updBy) {

		String sql = "Update Vote Set Updflag = :Updflag, updby = :Updby WHERE DistId = :DistId";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("Updflag", true);
		paramMap.put("Updby", updBy);
		paramMap.put("DistId", districtId);
		
		try {
			int count = namedParameterJdbcTemplate.update(sql, paramMap); 
			if (count == 0) {
				System.out.println("failed - requestToModifiedElectionResult() for districtId = " + districtId);
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("catch - requestToModifiedElectionResult() -> " + e.toString());
		}
		return false;
	}

	@Override
	public List<VoteModel> getApprovedModifications() {
		String sql = "Select * From Vote Where Aprvflag = :Aprvflag AND Updflag is null AND UpdAprvFlag is null Order by aprvDTM";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("Aprvflag", false);
		
		List<VoteModel> resultRequestModifications = new ArrayList<VoteModel>();
		
		try {
			resultRequestModifications = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getApprovedModifications() -> " + e.toString());
		}

		return resultRequestModifications;
	}
	
	@Override
	public List<VoteModel> getPendingRequestedApproval() {
		String sql = "Select * From Vote Where " +
					 "AprvFlag is null AND UpdFlag = :UpdFlag1 AND UpdAprvFlag is null OR " +
					 "AprvFlag = :AprvFlag2 AND UpdFlag = :UpdFlag2 AND UpdAprvFlag is null " +
					 "Order by updDTM";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("AprvFlag2", true);
		paramMap.put("UpdFlag1", true);
		paramMap.put("UpdFlag2", true);
		
		List<VoteModel> resultRequestedConfirmations = new ArrayList<VoteModel>();
		try {
			resultRequestedConfirmations = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<VoteModel>(VoteModel.class));
		} catch (Exception e) {
			System.out.println("catch - getPendingRequestedApproval() -> " + e.toString());
		}
		
		return resultRequestedConfirmations;
	}
	
	@Override
	public ArrayList<Integer> getNotApprovedDistrictsByProvince(int provinceId) {
		String sql = "Select Province.PrvID as provinceId, Province.numDist as numberAllDistricts, Vote.DistNum as voteDistrictNumber " + 
					 "From Province " + 
					 "Left join Vote on Province.PrvID = Vote.PrvID " + 
					 "Where Province.PrvID = :PrvID";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("PrvID", provinceId);
		
		List<ProvinceDistrictVote> districtProvinceList = new ArrayList<ProvinceDistrictVote>();
		
		try {
			districtProvinceList = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<ProvinceDistrictVote>(ProvinceDistrictVote.class));
		} catch (Exception e) {
			System.out.println("catch - getNotApprovedDistrictsByProvince() -> " + e.toString());
		}

		ArrayList<Integer> notApprovedDistrictList = new ArrayList<>();
		
		if (districtProvinceList.size() > 0) {	
			ArrayList<Integer> approvedDistrictList = new ArrayList<>();
			for (ProvinceDistrictVote value: districtProvinceList) {
				Integer voteDistrictNumber = value.getVoteDistrictNumber();
				if (voteDistrictNumber != null) {
					approvedDistrictList.add(voteDistrictNumber);
				}
			}
			
			int numberAllDistricts = districtProvinceList.get(0).getNumberAllDistricts();
			for (int i = 1; i <= numberAllDistricts; i++) {
				if (!approvedDistrictList.contains(i)) {
					notApprovedDistrictList.add(i);
				}
			}
		}
		
		Collections.sort(notApprovedDistrictList);
		return notApprovedDistrictList;
	}
}
