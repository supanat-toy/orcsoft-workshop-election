package th.co.orcsoft.training.model.common.dashboard.response;

import th.co.orcsoft.training.model.common.AbsResponseModel;

import java.util.ArrayList;

import lombok.Data;

@Data
public class NotCreatedDistrictsResponse extends AbsResponseModel {
	
	private ArrayList<Integer> notApprovedDistrictList;

}
