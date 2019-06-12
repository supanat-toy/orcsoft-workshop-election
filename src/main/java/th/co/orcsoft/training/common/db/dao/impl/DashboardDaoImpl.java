package th.co.orcsoft.training.common.db.dao.impl;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.DashboardDao;
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
	
}
