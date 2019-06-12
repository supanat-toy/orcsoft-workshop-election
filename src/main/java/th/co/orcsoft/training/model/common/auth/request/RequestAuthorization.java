package th.co.orcsoft.training.model.common.auth.request;

import th.co.orcsoft.training.model.common.AbsRequestModel;

public class RequestAuthorization extends AbsRequestModel {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
