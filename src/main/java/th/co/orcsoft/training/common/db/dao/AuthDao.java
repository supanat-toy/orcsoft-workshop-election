package th.co.orcsoft.training.common.db.dao;

import th.co.orcsoft.training.model.db.UsersModel;

public interface AuthDao {

	public UsersModel login(String username, String password);

	public UsersModel getUserProfile(int id);

}
