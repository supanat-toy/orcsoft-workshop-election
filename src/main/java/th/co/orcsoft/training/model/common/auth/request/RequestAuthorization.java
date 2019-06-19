package th.co.orcsoft.training.model.common.auth.request;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsRequestModel;

@Data
public class RequestAuthorization extends AbsRequestModel {

	private String username;
	private String password;
}
