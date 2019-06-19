package th.co.orcsoft.training.model.common.district.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.VoteModel;

@Data
public class GetResultRequestedModiResponse extends AbsResponseModel {
	
	private List<VoteModel> voteList;

}
