package th.co.orcsoft.training.model.db;

public class UsersModel {
	private int uID;
	private String login;
	private String pwd;
	private String posn;
	private String fullname;

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPosn() {
		return posn;
	}

	public void setPosn(String posn) {
		this.posn = posn;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
