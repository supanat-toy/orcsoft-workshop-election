package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.ProvinceModel;

public class GetAllProvinces extends AbsResponseModel {
	private List<ProvinceModel> provinceList;

	public List<ProvinceModel> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<ProvinceModel> provinceList) {
		this.provinceList = provinceList;
	}
}
