package th.co.orcsoft.training.model.common.center.request;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsRequestModel;

@Data
public class RequestedModification extends AbsRequestModel{

	private boolean isApproved;
	private int districtId;
	
}
