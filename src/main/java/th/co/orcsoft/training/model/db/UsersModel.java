package th.co.orcsoft.training.model.db;

import lombok.Data;

@Data
public class UsersModel {
	private int uID;
	private String login;
	private String pwd;
	private String posn;
	private String fullname;
}
