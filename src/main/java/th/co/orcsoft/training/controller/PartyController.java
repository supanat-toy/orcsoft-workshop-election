package th.co.orcsoft.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;

@RestController
@RequestMapping(value = "/api/party")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartyController extends BaseController {

	@Autowired
	private PartyService partyService;

	@GetMapping(value = "getAllParty", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody AbsResponseModel getAllMenuList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		GetAllPartyResponse getAllPartyResponse = new GetAllPartyResponse();
		getAllPartyResponse.setPartyList(partyService.getAllParty());
		return getAllPartyResponse;
	}
}
