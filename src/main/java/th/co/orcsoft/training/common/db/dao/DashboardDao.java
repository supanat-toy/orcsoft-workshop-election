package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

public interface DashboardDao {
	public List<ProvinceModel> getProvinces();
	public List<RegionModel> getRegions();
	public List<Object> getElectionPartyDistricts(int provinceId);
	public List<Object> getElectionPartyRegion(int regionId);
}
