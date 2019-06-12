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
import th.co.orcsoft.training.model.common.dashboard.response.GetAllProvinces;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;
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

		return null;
	}
	
	@RequestMapping(value = "getElectionPartyDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getElectionPartyDistricts(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		String userId = this.getUserIdByHeader(response);
		List<Object> electionPartyDistricts = dashboardService.getElectionPartyDistricts(provinceId);

		return null;
	}
	
	@RequestMapping(value = "getElectionPartyRegion", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getElectionPartyRegion(int regionId, HttpServletRequest request, HttpServletResponse response) {
		
		String userId = this.getUserIdByHeader(response);
		List<Object> electionPartyRegion = dashboardService.getElectionPartyRegion(regionId);

		return null;
	}
}
