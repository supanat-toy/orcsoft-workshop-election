package th.co.orcsoft.training.model.db;

public class UsersModel {
	private int UID;
	private String Login;
	private String Pwd;
	private String Posn;
	private String Fullname;
	
	
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getPosn() {
		return Posn;
	}
	public void setPosn(String posn) {
		Posn = posn;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}

}
