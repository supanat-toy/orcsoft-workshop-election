package th.co.orcsoft.training.model.common.center.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.center.request.RequestedConfirmation;
import th.co.orcsoft.training.model.db.VoteModel;

@Data
public class RequestedApprovalsResponse extends AbsResponseModel{
	 
	private List<VoteModel> listRequestCon;

}
