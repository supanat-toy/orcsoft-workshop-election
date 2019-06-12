package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;
import java.util.ArrayList;

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
		String sql = "SELECT * FROM PROVINCE";
		List<ProvinceModel> provinces = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<ProvinceModel>(ProvinceModel.class));
		return provinces;
	}

	@Override
	public List<RegionModel> getRegions() {
		String sql = "SELECT * FROM REGION";
		List<RegionModel> regions = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<RegionModel>(RegionModel.class));
		return regions;
	}

	@Override
	public List<GetElectionPartyDistrictsModel> getElectionPartyDistricts(int provinceId) {
		String sql = "SELECT vote.*,\r\n" + 
				"        pty1.ptyName as pty1_Name,\r\n" + 
				"        pty1.Logo as pty1_Logo,\r\n" + 
				"        pty2.ptyName as pty2_Name,\r\n" + 
				"        pty2.Logo as pty2_Logo,\r\n" + 
				"        pty3.ptyName as pty3_Name,\r\n" + 
				"        pty3.Logo as pty3_Logo\r\n" + 
				"        FROM vote\r\n" + 
				"        INNER JOIN party as pty1\r\n" + 
				"                ON vote.Pty1_ID = pty1.PtyID\r\n" + 
				"        INNER JOIN party as pty2\r\n" + 
				"                ON vote.Pty2_ID = pty2.PtyID\r\n" + 
				"        INNER JOIN party as pty3\r\n" + 
				"                ON vote.Pty3_ID = pty3.PtyID\r\n" + 
				"        WHERE vote.PrvID ="+provinceId+" AND AprvFlag = 'true'\r\n" + 
				"        ORDER BY vote.DistNum;";
		List<GetElectionPartyDistrictsModel> ElectionPartyDistricts = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<GetElectionPartyDistrictsModel>(GetElectionPartyDistrictsModel.class));
		return ElectionPartyDistricts;
	}

	@Override
	public List<GetElectionPartyRegionModel> getElectionPartyRegion(int regionId) {
		String sql = "select SUM_MHR_BY_REGION.*,\r\n" + 
				"        pty.ptyName as ptyName,\r\n" + 
				"        pty.Logo as Logo\r\n" + 
				"        FROM SUM_MHR_BY_REGION\r\n" + 
				"        INNER JOIN party as pty\r\n" + 
				"                ON SUM_MHR_BY_REGION.PtyID = pty.PtyID\r\n" + 
				"        WHERE SUM_MHR_BY_REGION.RgnID ="+regionId+"\r\n" + 
				"        ORDER BY SUM_MHR_BY_REGION.mHR desc;";
		List<GetElectionPartyRegionModel> ElectionPartyRegion = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<GetElectionPartyRegionModel>(GetElectionPartyRegionModel.class));
		return ElectionPartyRegion;
	}

	@Override
	public ArrayList<Integer> getNotApprovedDistrictsByProvince(int provinceId) {
		String sql = "select Province.PrvID as provinceId, Province.numDist as numberAllDistricts, Vote.DistNum as voteDistrictNumber " + 
					 "from Province " + 
					 "left join Vote on Province.PrvID = Vote.PrvID " + 
					 "where Province.PrvID = " + provinceId;
		
		List<ProvinceDistrictVote> districtProvinceList = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<ProvinceDistrictVote>(ProvinceDistrictVote.class));

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
		String sql = "select SUM_MHR_BY_PROVINCE.*,\r\n" + 
				"        pty.ptyName as ptyName,\r\n" + 
				"        pty.Logo as Logo,\r\n" + 
				"        pty.ptyAbbr as ptyAbbr\r\n" + 
				"        FROM SUM_MHR_BY_PROVINCE\r\n" + 
				"        INNER JOIN party as pty\r\n" + 
				"                ON SUM_MHR_BY_PROVINCE.PtyID = pty.PtyID\r\n" + 
				"        WHERE SUM_MHR_BY_PROVINCE.PrvID = "+provinceId+" \r\n" + 
				"        ORDER BY SUM_MHR_BY_PROVINCE.mHR desc;";
		List<GetSummaryElectionPartyDistrictsModel> SummaryElectionPartyDistricts = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<GetSummaryElectionPartyDistrictsModel>(GetSummaryElectionPartyDistrictsModel.class));
		return SummaryElectionPartyDistricts;
	}
}
