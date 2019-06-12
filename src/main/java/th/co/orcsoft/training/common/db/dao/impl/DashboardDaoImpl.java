package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.DashboardDao;
import th.co.orcsoft.training.model.db.ProvinceDistrictVote;
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
	public List<Object> getElectionPartyDistricts(int provinceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getElectionPartyRegion(int regionId) {
		// TODO Auto-generated method stub
		return null;
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
	
}
