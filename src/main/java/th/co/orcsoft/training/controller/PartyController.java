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

import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.dashboard.response.AllProvincesResponse;
import th.co.orcsoft.training.model.common.dashboard.response.AllRegionsResponse;
import th.co.orcsoft.training.model.common.party.response.AllPartiesResponse;
import th.co.orcsoft.training.model.db.ProvinceModel;
import th.co.orcsoft.training.model.db.RegionModel;

@RestController
@RequestMapping(value = "/api/party")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartyController extends BaseController {

	@Autowired
	private PartyService partyService;

	@GetMapping(value = "getAllParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody AbsResponseModel getAllMenuList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		AllPartiesResponse allPartiesResponse = new AllPartiesResponse();
		allPartiesResponse.setPartyList(partyService.getAllParty());
		return allPartiesResponse;
	}
	
	@RequestMapping(value = "getAllProvinces", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getProvinces(HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		List<ProvinceModel> provinces = partyService.getAllProvinces();

		AllProvincesResponse allProvincesResponse = new AllProvincesResponse();
		allProvincesResponse.setProvinceList(provinces);
		
		return allProvincesResponse;
	}
	
	@RequestMapping(value = "getAllRegions", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRegions(HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		List<RegionModel> regions = partyService.getAllRegions();

		AllRegionsResponse allRegionsResponse = new AllRegionsResponse();
		allRegionsResponse.setRegionList(regions);
		
		return allRegionsResponse;
	}
}
