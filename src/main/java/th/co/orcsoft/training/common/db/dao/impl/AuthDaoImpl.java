package th.co.orcsoft.training.common.db.dao.impl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.model.db.UsersModel;

@Repository
public class AuthDaoImpl extends AbsCorDao implements AuthDao {

	@Override
	public UsersModel login(String username, String password) {
		String sql = "Select * From Users Where Login = :username and Pwd = :password";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", username);
		paramMap.put("password", password);
		
		UsersModel user = null;
		try {
			user = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<UsersModel>(UsersModel.class));
		} catch (Exception e) {
			System.out.println("catch - login() -> " + e.toString());
		}
		
		return user;
	}

	@Override
	public UsersModel getUserProfile(int id) {
		String sql = "Select * From Users Where UID = :UID";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("UID", id);
		
		UsersModel user = null;
		try {
			user = namedParameterJdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<UsersModel>(UsersModel.class));
		} catch (Exception e) {
			System.out.println("catch - getUserProfile() -> " + e.toString());
		}
		
		return user;
	}

}
