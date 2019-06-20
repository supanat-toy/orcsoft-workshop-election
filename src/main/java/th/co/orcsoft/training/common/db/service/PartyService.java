package th.co.orcsoft.training.common.db.service;

import java.util.List;

import th.co.orcsoft.training.model.db.PartyModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

public interface PartyService {
	public List<PartyModel> getAllParty();
	public List<ProvinceModel> getAllProvinces();
	public List<RegionModel> getAllRegions();
}
