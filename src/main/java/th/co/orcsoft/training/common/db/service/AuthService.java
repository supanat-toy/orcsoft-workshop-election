package th.co.orcsoft.training.common.db.service;

import th.co.orcsoft.training.model.db.UsersModel;

public interface AuthService {
	public UsersModel login(String username, String password);

	public UsersModel getUserProfile(int id);
}
