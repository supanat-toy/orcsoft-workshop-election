package th.co.orcsoft.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.orcsoft.training.common.db.service.DashboardService;
import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.dashboard.response.GetElectionPartyDistricts;
import th.co.orcsoft.training.model.common.dashboard.response.GetElectionPartyRegion;
import th.co.orcsoft.training.model.common.dashboard.response.GetSummaryElectionPartyDistricts;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;
import th.co.orcsoft.training.model.db.GetElectionPartyDistrictsModel;
import th.co.orcsoft.training.model.db.GetElectionPartyRegionModel;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;
import th.co.orcsoft.training.model.db.VoteModel;

@RestController
@RequestMapping(value = "/api/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController extends BaseController {

	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value = "getProvinces", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getProvinces(HttpServletRequest request, HttpServletResponse response) {
		
		List<ProvinceModel> provinces = dashboardService.getProvinces();

		GetAllProvinces getAllProvinces = new GetAllProvinces();
		getAllProvinces.setProvinceList(provinces);
		
		return getAllProvinces;
	}
	
	@RequestMapping(value = "getRegions", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRegions(HttpServletRequest request, HttpServletResponse response) {
		
		List<RegionModel> regions = dashboardService.getRegions();

		GetAllRegions allRegions = new GetAllRegions();
		allRegions.setRegionList(regions);
		
		return allRegions;
	}
	
	@RequestMapping(value = "getElectionPartyDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody GetElectionPartyDistricts getElectionPartyDistricts(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		String userId = this.getUserIdByHeader(response);
		GetElectionPartyDistricts electionPartyDistricts = new GetElectionPartyDistricts();
		electionPartyDistricts.setGetElectionPartyDistrictsList(dashboardService.getElectionPartyDistricts(provinceId));
		
		return electionPartyDistricts;
	}
	
	@RequestMapping(value = "getElectionPartyRegion", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody GetElectionPartyRegion getElectionPartyRegion(int regionId, HttpServletRequest request, HttpServletResponse response) {
		
		String userId = this.getUserIdByHeader(response);
		GetElectionPartyRegion electionPartyRegion = new GetElectionPartyRegion();
		electionPartyRegion.setGetElectionPartyRegionList(dashboardService.getElectionPartyRegion(regionId));
		 
		return electionPartyRegion;
	}
	
	@RequestMapping(value = "getSummaryElectionPartyDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody GetSummaryElectionPartyDistricts getSummaryElectionPartyDistricts(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		String userId = this.getUserIdByHeader(response);
		GetSummaryElectionPartyDistricts summaryElectionPartyDistricts = new GetSummaryElectionPartyDistricts();
		summaryElectionPartyDistricts.setGetSummaryElectionPartyDistricts(dashboardService.getSummaryElectionPartyDistricts(provinceId));	 
		return summaryElectionPartyDistricts;
	}

}
