package th.co.orcsoft.training.model.common.district.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.PartyModel;
import th.co.orcsoft.training.model.db.VoteModel;

public class GetResultRequestedModiResponse extends AbsResponseModel {

	private List<VoteModel> voteList;

	public List<VoteModel> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<VoteModel> voteList) {
		this.voteList = voteList;
	}

}
