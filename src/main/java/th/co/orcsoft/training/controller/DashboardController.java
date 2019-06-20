package th.co.orcsoft.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.orcsoft.training.common.db.service.DashboardService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.dashboard.response.AllRegionsResponse;
import th.co.orcsoft.training.model.common.dashboard.response.NotCreatedDistrictsResponse;
import th.co.orcsoft.training.model.common.dashboard.response.AllProvincesResponse;
import th.co.orcsoft.training.model.common.dashboard.response.ElectionPartyDistrictsResponse;
import th.co.orcsoft.training.model.common.dashboard.response.ElectionPartyRegionResponse;
import th.co.orcsoft.training.model.common.dashboard.response.SummaryElectionPartyDistrictsResponse;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController extends BaseController {

	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value = "getElectionPartyDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody ElectionPartyDistrictsResponse getElectionPartyDistricts(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		ElectionPartyDistrictsResponse electionPartyDistrictsResponse = new ElectionPartyDistrictsResponse();
		electionPartyDistrictsResponse.setElectionPartyDistrictsList(dashboardService.getElectionPartyDistricts(provinceId));
		
		return electionPartyDistrictsResponse;
	}
	
	@RequestMapping(value = "getElectionPartyRegion", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody ElectionPartyRegionResponse getElectionPartyRegion(int regionId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		ElectionPartyRegionResponse electionPartyRegionResponse = new ElectionPartyRegionResponse();
		electionPartyRegionResponse.setElectionPartyRegionList(dashboardService.getElectionPartyRegion(regionId));
		 
		return electionPartyRegionResponse;
	}
	
	@RequestMapping(value = "getSummaryElectionPartyDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody SummaryElectionPartyDistrictsResponse getSummaryElectionPartyDistricts(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}

		SummaryElectionPartyDistrictsResponse summaryElectionPartyDistrictsResponse = new SummaryElectionPartyDistrictsResponse();
		summaryElectionPartyDistrictsResponse.setSummaryElectionPartyDistrictsList(dashboardService.getSummaryElectionPartyDistricts(provinceId));	 
		return summaryElectionPartyDistrictsResponse;
	}

}
