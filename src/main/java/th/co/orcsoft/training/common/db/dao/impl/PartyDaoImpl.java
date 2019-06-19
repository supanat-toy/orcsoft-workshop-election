package th.co.orcsoft.training.common.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.PartyDao;
import th.co.orcsoft.training.model.db.PartyModel;

@Repository
public class PartyDaoImpl extends AbsCorDao implements PartyDao {

	@Override
	public List<PartyModel> getAllParty() {
		String sql = "Select * From Party Order by Party.ptyName";

		List<PartyModel> parties = new ArrayList<PartyModel>();
		
		try {
			parties = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<PartyModel>(PartyModel.class));
		} catch (Exception e) {
			System.out.println("catch - getAllParty() -> " + e.toString());
		}
		
		return parties;
	}

}
