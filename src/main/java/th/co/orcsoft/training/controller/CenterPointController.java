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

import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.common.db.service.CenterPointService;
import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.auth.response.GetAuthorization;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;

@RestController
@RequestMapping(value = "/api/centerpoint") 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CenterPointController extends BaseController {
	
	@Autowired
	private CenterPointService centerPointService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "getRequestedConfirmations", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		boolean isOfficer = this.isOfficerByHeader(response);
		List<VoteModel> requestedConfirmations = centerPointService.getRequestedConfirmations();

		return null;
	}
	
	@RequestMapping(value = "getRequestedModifications", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedModifications(HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		boolean isOfficer = this.isOfficerByHeader(response);
		List<VoteModel> requestedModifications = centerPointService.getRequestedModifications();

		return null;
	}
	
	@RequestMapping(value = "replyRequestedConfirmation", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedConfirmation(int districtId, boolean isApproved, HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		centerPointService.replyRequestedConfirmations(districtId, isApproved);

		return null;
	}
	
	@RequestMapping(value = "replyRequestedModification", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedModification(int districtId, boolean isApproved, HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		centerPointService.replyRequestedModifications(districtId, isApproved,userProfile.getLogin());
		
		return null;
	}
}
