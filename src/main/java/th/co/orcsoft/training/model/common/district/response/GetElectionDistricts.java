package th.co.orcsoft.training.model.common.district.response;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.VoteModel;

public class GetElectionDistricts extends AbsResponseModel {

	private VoteModel voteModel;

	public VoteModel getVoteModel() {
		return voteModel;
	}

	public void setVoteModel(VoteModel voteModel) {
		this.voteModel = voteModel;
	}
}
