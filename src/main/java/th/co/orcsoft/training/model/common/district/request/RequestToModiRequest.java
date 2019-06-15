package th.co.orcsoft.training.model.common.district.request;

import th.co.orcsoft.training.model.common.AbsRequestModel;

public class RequestToModiRequest extends AbsRequestModel {

	private int districtId;

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
}
