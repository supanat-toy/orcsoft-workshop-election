package th.co.orcsoft.training.model.common.auth.response;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.UsersModel;

public class GetAuthorization extends AbsResponseModel {
	
	private UsersModel user;
	private String token;
	
	public UsersModel getUser() {
		return user;
	}
	public void setUser(UsersModel user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
