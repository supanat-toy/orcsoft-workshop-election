package th.co.orcsoft.training.common.db.service;

import java.util.ArrayList;
import java.util.List;

import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;
import th.co.orcsoft.training.model.db.GetSummaryElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

public interface DashboardService {
	public List<ProvinceModel> getProvinces();

	public List<RegionModel> getRegions();

	public List<GetElectionPartyDistrictsModel> getElectionPartyDistricts(int provinceId);

	public List<GetElectionPartyRegionModel> getElectionPartyRegion(int regionId);

	public List<GetSummaryElectionPartyDistrictsModel> getSummaryElectionPartyDistricts(int provinceId);

	public ArrayList<Integer> getNotApprovedDistrictsByProvince(int provinceId);
}
