package th.co.orcsoft.training.common.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.PartyDao;
import th.co.orcsoft.training.model.db.PartyModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

@Repository
public class PartyDaoImpl extends AbsCorDao implements PartyDao {

	@Override
	public List<PartyModel> getAllParties() {
		String sql = "Select * From Party Order by Party.ptyName";

		List<PartyModel> parties = new ArrayList<PartyModel>();
		
		try {
			parties = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<PartyModel>(PartyModel.class));
		} catch (Exception e) {
			System.out.println("catch - getAllParties() -> " + e.toString());
		}
		
		return parties;
	}
	
	@Override
	public List<ProvinceModel> getAllProvinces() {
		String sql = "Select * From Province";
		List<ProvinceModel> provinces = new ArrayList<ProvinceModel>();
		
		try {
			provinces = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<ProvinceModel>(ProvinceModel.class));
		} catch (Exception e) {
			System.out.println("catch - getAllProvinces() -> " + e.toString());
		}
		
		return provinces;
	}

	@Override
	public List<RegionModel> getAllRegions() {
		String sql = "Select * From Region";
		List<RegionModel> regions = new ArrayList<RegionModel>();
		
		try {
			regions = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<RegionModel>(RegionModel.class));
		} catch (Exception e) {
			System.out.println("catch - getAllRegions() -> " + e.toString());
		}
		
		return regions;
	}

}
