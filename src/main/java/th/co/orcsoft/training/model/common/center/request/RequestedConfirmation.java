package th.co.orcsoft.training.model.common.center.request;

import th.co.orcsoft.training.model.common.AbsRequestModel;

public class RequestedConfirmation extends AbsRequestModel{
	
	private boolean isApproved;
	private int districtId;
	
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public int getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	

}
