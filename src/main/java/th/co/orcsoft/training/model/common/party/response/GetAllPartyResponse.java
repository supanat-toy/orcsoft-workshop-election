package th.co.orcsoft.training.model.common.party.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.dashboard.response.GetElectionPartyDistricts;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.PartyModel;

@Data
public class GetAllPartyResponse extends AbsResponseModel {

	private List<PartyModel> partyList;
}
