package th.co.orcsoft.training.model.common.center.response;

import java.util.List;

import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.VoteModel;

public class GetRequestedConfirmations extends AbsResponseModel{
	 private List<VoteModel> listRequestCon;

	public List<VoteModel> getListRequestCon() {
		return listRequestCon;
	}

	public void setListRequestCon(List<VoteModel> listRequestCon) {
		this.listRequestCon = listRequestCon;
	} 
}
