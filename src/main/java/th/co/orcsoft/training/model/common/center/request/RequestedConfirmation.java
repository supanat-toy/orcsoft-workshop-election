package th.co.orcsoft.training.model.common.center.request;

import th.co.orcsoft.training.model.common.AbsRequestModel;

public class RequestedConfirmation extends AbsRequestModel{
	
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
