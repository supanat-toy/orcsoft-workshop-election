package th.co.orcsoft.training.model.common.center.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.VoteModel;

public class GetModifications extends AbsResponseModel {
	private List<VoteModel> listRequestModi;

	public List<VoteModel> getListRequestModi() {
		return listRequestModi;
	}

	public void setListRequestModi(List<VoteModel> listRequestModi) {
		this.listRequestModi = listRequestModi;
	}
}
