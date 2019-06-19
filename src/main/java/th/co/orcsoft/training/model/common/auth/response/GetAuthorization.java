package th.co.orcsoft.training.model.common.auth.response;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.UsersModel;

@Data
public class GetAuthorization extends AbsResponseModel {
	
	private UsersModel user;
	private String token;
	
}
