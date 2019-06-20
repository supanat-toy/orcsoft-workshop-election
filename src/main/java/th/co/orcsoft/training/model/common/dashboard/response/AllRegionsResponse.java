package th.co.orcsoft.training.model.common.dashboard.response;

import java.util.List;

import lombok.Data;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.db.RegionModel;

@Data
public class AllRegionsResponse extends AbsResponseModel {

	private List<RegionModel> regionList;
}
