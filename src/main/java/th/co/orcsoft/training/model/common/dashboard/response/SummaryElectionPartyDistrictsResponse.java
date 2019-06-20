package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.GetSummaryElectionPartyDistrictsModel;

@Data
public class SummaryElectionPartyDistrictsResponse {
	
	private List<GetSummaryElectionPartyDistrictsModel> SummaryElectionPartyDistrictsList;
	
}
