package th.co.orcsoft.training.common.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.model.db.UsersModel;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;
	
	@Override
	public UsersModel login(String username, String password) {
		UsersModel user = authDao.login(username, password);
		return user;
	}

}
