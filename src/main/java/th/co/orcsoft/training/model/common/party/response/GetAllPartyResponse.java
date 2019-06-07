package th.co.orcsoft.training.model.common.party.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.PartyModel;

public class GetAllPartyResponse extends AbsResponseModel {

	private List<PartyModel> partyList;

	public List<PartyModel> getPartyList() {
		return partyList;
	}

	public void setPartyList(List<PartyModel> partyList) {
		this.partyList = partyList;
	}
}
