package th.co.orcsoft.training.common.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.orcsoft.training.common.db.dao.DashboardDao;
import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.common.db.service.DashboardService;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;
import th.co.orcsoft.training.model.db.GetSummaryElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardDao dashboardDao;
	
	@Override
	public List<ProvinceModel> getProvinces() {
		return dashboardDao.getProvinces();
	}

	@Override
	public List<RegionModel> getRegions() {
		return dashboardDao.getRegions();
	}

	@Override
	public List<GetElectionPartyDistrictsModel> getElectionPartyDistricts(int provinceId) {
		return dashboardDao.getElectionPartyDistricts(provinceId);
	}
	
	@Override
	public List<GetElectionPartyRegionModel> getElectionPartyRegion(int regionId) {
		return dashboardDao.getElectionPartyRegion(regionId);
	}
	
	@Override
	public List<GetSummaryElectionPartyDistrictsModel> getSummaryElectionPartyDistricts(int provinceId) {
		return dashboardDao.getSummaryElectionPartyDistricts(provinceId);
	}
	


}
