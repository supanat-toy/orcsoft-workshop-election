package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;

@Data
public class GetElectionPartyRegion {
	
	private List<GetElectionPartyRegionModel> ElectionPartyRegionList;

}
