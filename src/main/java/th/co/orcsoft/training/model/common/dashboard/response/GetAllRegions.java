package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.RegionModel;

public class GetAllRegions extends AbsResponseModel {

	private List<RegionModel> regionList;

	public List<RegionModel> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<RegionModel> regionList) {
		this.regionList = regionList;
	}
}
