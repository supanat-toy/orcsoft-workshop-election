package th.co.orcsoft.training.common.db.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import th.co.orcsoft.training.common.db.dao.AbsCorDao;
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.model.db.UsersModel;

@Repository
public class AuthDaoImpl extends AbsCorDao implements AuthDao {

	@Override
	public UsersModel login(String username, String password) {
		String sql = String.format("SELECT TOP 1 * FROM USERS WHERE Login = '%s' and Pwd = '%s'", username, password);
		List<UsersModel> userList = namedParameterJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UsersModel>(UsersModel.class));

		if (userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public UsersModel getUserProfile(int id) {
		String sql = String.format("SELECT TOP 1 * FROM USERS WHERE UID = '%s'", id);
		List<UsersModel> userList = namedParameterJdbcTemplate.query(sql,
				new BeanPropertyRowMapper<UsersModel>(UsersModel.class));

		if (userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

}
