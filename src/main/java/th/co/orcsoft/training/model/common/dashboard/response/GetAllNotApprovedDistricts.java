package th.co.orcsoft.training.model.common.dashboard.response;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import java.util.ArrayList;

public class GetAllNotApprovedDistricts extends AbsResponseModel {
	private ArrayList<Integer> notApprovedDistrictList;

	public ArrayList<Integer> getNotApprovedDistrictList() {
		return notApprovedDistrictList;
	}

	public void setNotApprovedDistrictList(ArrayList<Integer> notApprovedDistrictList) {
		this.notApprovedDistrictList = notApprovedDistrictList;
	}
}
