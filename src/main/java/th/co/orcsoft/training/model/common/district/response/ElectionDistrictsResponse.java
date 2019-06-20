package th.co.orcsoft.training.model.common.district.response;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.VoteModel;

@Data
public class ElectionDistrictsResponse extends AbsResponseModel{

	private VoteModel voteModel;

}
