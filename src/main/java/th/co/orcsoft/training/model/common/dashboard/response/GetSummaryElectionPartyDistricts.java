package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import th.co.orcsoft.training.model.db.GetSummaryElectionPartyDistrictsModel;

public class GetSummaryElectionPartyDistricts {
	private List<GetSummaryElectionPartyDistrictsModel> SummaryElectionPartyDistrictsList;

	public List<GetSummaryElectionPartyDistrictsModel> getSummaryElectionPartyDistrictsList() {
		return SummaryElectionPartyDistrictsList;
	}

	public void setGetSummaryElectionPartyDistricts(
			List<GetSummaryElectionPartyDistrictsModel> SummaryElectionPartyDistrictsList) {
		this.SummaryElectionPartyDistrictsList = SummaryElectionPartyDistrictsList;
	}
}
