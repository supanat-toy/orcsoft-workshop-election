package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;

public class GetElectionPartyDistricts {

	private List<GetElectionPartyDistrictsModel> ElectionPartyDistrictsList;

	public List<GetElectionPartyDistrictsModel> getElectionPartyDistrictsList() {
		return ElectionPartyDistrictsList;
	}

	public void setGetElectionPartyDistrictsList(List<GetElectionPartyDistrictsModel> ElectionPartyDistrictsList) {
		this.ElectionPartyDistrictsList = ElectionPartyDistrictsList;
	}
}
