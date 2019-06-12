package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;

public class GetElectionPartyRegion {
private List<GetElectionPartyRegionModel> ElectionPartyRegionList;
	
	
	public List<GetElectionPartyRegionModel> getElectionPartyRegionList() {
		return ElectionPartyRegionList;
	}

	public void setGetElectionPartyRegionList(List<GetElectionPartyRegionModel> ElectionPartyRegionList) {
		this.ElectionPartyRegionList = ElectionPartyRegionList;
	}
}
