package th.co.orcsoft.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.common.db.service.CenterPointService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.center.response.GetConfirmations;
import th.co.orcsoft.training.model.common.center.response.GetModifications;
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

	@RequestMapping(value = "getConfirmations", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request,
			HttpServletResponse response) {
		GetConfirmations getConfirmations = new GetConfirmations();
		getConfirmations.setListRequestCon(centerPointService.getRequestedConfirmations());

		return getConfirmations;
	}

	@RequestMapping(value = "getModifications", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedModifications(HttpServletRequest request,
			HttpServletResponse response) {
		
		GetModifications getModifications = new GetModifications();
		getModifications.setListRequestModi(centerPointService.getRequestedModifications());
		return getModifications;
	}

	@RequestMapping(value = "replyRequestedConfirmation", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedConfirmation(@RequestBody int districtId, boolean isApproved,
			HttpServletRequest request, HttpServletResponse response) {

		int userId = this.getUserIdByHeader(response);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		centerPointService.replyRequestedConfirmations(districtId, isApproved, userProfile.getLogin());
		return null;
	}
	
	@RequestMapping(value = "replyRequestedModification", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedModification(@RequestBody int districtId, boolean isApproved,
			HttpServletRequest request, HttpServletResponse response) {

		int userId = this.getUserIdByHeader(response);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		centerPointService.replyRequestedModifications(districtId, isApproved, userProfile.getLogin());
		return null;
	}
	
}