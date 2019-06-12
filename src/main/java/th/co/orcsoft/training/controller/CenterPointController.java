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
import th.co.orcsoft.training.model.common.center.response.GetRequestedConfirmations;
import th.co.orcsoft.training.model.common.center.response.GetRequestedModifications;
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

	@RequestMapping(value = "getRequestedConfirmations", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request,
			HttpServletResponse response) {
		GetRequestedConfirmations getRequestedConfirmations = new GetRequestedConfirmations();
		getRequestedConfirmations.setListRequestCon(centerPointService.getRequestedConfirmations());

		return getRequestedConfirmations;
	}

	@RequestMapping(value = "getRequestedModifications", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedModifications(HttpServletRequest request,
			HttpServletResponse response) {
		
		GetRequestedModifications getRequestedModifications = new GetRequestedModifications();
		getRequestedModifications.setListRequestModi(centerPointService.getRequestedModifications());
		return getRequestedModifications;
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
