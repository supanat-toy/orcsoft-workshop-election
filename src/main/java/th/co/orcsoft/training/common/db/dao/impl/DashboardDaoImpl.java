package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.DashboardDao;
import th.co.orcsoft.training.model.db.ProvinceDistrictVote;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;
import th.co.orcsoft.training.model.db.GetSummaryElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

@Repository
public class DashboardDaoImpl extends AbsCorDao implements DashboardDao {

	@Override
	public List<ProvinceModel> getProvinces() {
		String sql = "Select * From Province";
		List<ProvinceModel> provinces = new ArrayList<ProvinceModel>();
		
		try {
			provinces = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<ProvinceModel>(ProvinceModel.class));
		} catch (Exception e) {
			System.out.println("catch - getProvinces() -> " + e.toString());
		}
		
		return provinces;
	}

	@Override
	public List<RegionModel> getRegions() {
		String sql = "Select * From Region";
		List<RegionModel> regions = new ArrayList<RegionModel>();
		
		try {
			regions = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<RegionModel>(RegionModel.class));
		} catch (Exception e) {
			System.out.println("catch - getRegions() -> " + e.toString());
		}
		
		return regions;
	}

	@Override
	public List<GetElectionPartyDistrictsModel> getElectionPartyDistricts(int provinceId) {
		String sql = "Select vote.*, " + 
				"     pty1.ptyName as pty1_Name, " + 
				"     pty1.Logo as pty1_Logo, " + 
				"     pty2.ptyName as pty2_Name, " + 
				"     pty2.Logo as pty2_Logo, " + 
				"     pty3.ptyName as pty3_Name, " + 
				"     pty3.Logo as pty3_Logo " + 
				"     From Vote " + 
				"     Inner Join party as pty1 on vote.Pty1_ID = pty1.PtyID " + 
				"     Inner Join party as pty2 on vote.Pty2_ID = pty2.PtyID " + 
				"     Inner Join party as pty3 on vote.Pty3_ID = pty3.PtyID " + 
				"     Where vote.PrvID = :PrvID and AprvFlag = :AprvFlag " + 
				"     Order by vote.DistNum;";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("PrvID", provinceId);
		paramMap.put("AprvFlag", true);
		
		List<GetElectionPartyDistrictsModel> electionPartyDistricts = new ArrayList<GetElectionPartyDistrictsModel>();
		
		try {
			electionPartyDistricts = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<GetElectionPartyDistrictsModel>(GetElectionPartyDistrictsModel.class));
		} catch (Exception e) {
			System.out.println("catch - getElectionPartyDistricts() -> " + e.toString());
		}
		
		return electionPartyDistricts;
	}

	@Override
	public List<GetElectionPartyRegionModel> getElectionPartyRegion(int regionId) {
		String sql = "Select SUM_MHR_BY_REGION.*, " + 
				"     pty.ptyName as ptyName, " + 
				"     pty.Logo as Logo, " + 
				"     pty.ptyAbbr as ptyAbbr " + 
				"     From SUM_MHR_BY_REGION " + 
				"     Inner Join party as pty on SUM_MHR_BY_REGION.PtyID = pty.PtyID " + 
				"     Where SUM_MHR_BY_REGION.RgnID = :RgnID" + 
				"     Order By SUM_MHR_BY_REGION.mHR desc";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("RgnID", regionId);
		
		List<GetElectionPartyRegionModel> electionPartyRegion = new ArrayList<GetElectionPartyRegionModel>();
		
		try {
			electionPartyRegion = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<GetElectionPartyRegionModel>(GetElectionPartyRegionModel.class));
		} catch (Exception e) {
			System.out.println("catch - getElectionPartyRegion() -> " + e.toString());
		}
		
		return electionPartyRegion;
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
		
		return notApprovedDistrictList;
	}
	
	@Override
	public List<GetSummaryElectionPartyDistrictsModel> getSummaryElectionPartyDistricts(int provinceId) {
		String sql = "Select SUM_MHR_BY_PROVINCE.*, " + 
				"     pty.ptyID as ptyID, " + 
				"     pty.ptyName as ptyName, " + 
				"     pty.Logo as Logo, " + 
				"     pty.ptyAbbr as ptyAbbr " + 
				"     From SUM_MHR_BY_PROVINCE " + 
				"     Inner Join party as pty on SUM_MHR_BY_PROVINCE.PtyID = pty.PtyID " + 
				"     Where SUM_MHR_BY_PROVINCE.PrvID = :PrvID " + 
				"     Order by SUM_MHR_BY_PROVINCE.mHR desc";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("PrvID", provinceId);
		
		List<GetSummaryElectionPartyDistrictsModel> summaryElectionPartyDistricts = new ArrayList<GetSummaryElectionPartyDistrictsModel>();
		
		try {
			summaryElectionPartyDistricts = namedParameterJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<GetSummaryElectionPartyDistrictsModel>(GetSummaryElectionPartyDistrictsModel.class));
		} catch (Exception e) {
			System.out.println("catch - getSummaryElectionPartyDistricts() -> " + e.toString());
		}
		
		return summaryElectionPartyDistricts;
	}
}
