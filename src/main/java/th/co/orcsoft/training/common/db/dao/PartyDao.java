package th.co.orcsoft.training.common.db.dao;

import java.util.List;

import th.co.orcsoft.training.model.db.PartyModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

public interface PartyDao {

	public List<PartyModel> getAllParties();
	public List<ProvinceModel> getAllProvinces();
	public List<RegionModel> getAllRegions();
}
