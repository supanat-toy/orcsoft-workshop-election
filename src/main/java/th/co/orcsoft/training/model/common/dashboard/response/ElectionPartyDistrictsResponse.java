package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;

@Data
public class ElectionPartyDistrictsResponse {
	
	private List<GetElectionPartyDistrictsModel> ElectionPartyDistrictsList;
	
}
