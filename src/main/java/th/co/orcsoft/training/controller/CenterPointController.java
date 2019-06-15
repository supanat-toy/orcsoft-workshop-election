package th.co.orcsoft.training.controller;

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
import th.co.orcsoft.training.model.common.center.request.RequestedConfirmation;
import th.co.orcsoft.training.model.common.center.request.RequestedModification;
import th.co.orcsoft.training.model.common.center.response.GetConfirmations;
import th.co.orcsoft.training.model.common.center.response.GetModifications;
import th.co.orcsoft.training.model.db.UsersModel;

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
		GetConfirmations getConfirmations = new GetConfirmations();
		getConfirmations.setListRequestCon(centerPointService.getRequestedConfirmations());

		return getConfirmations;
	}

	@RequestMapping(value = "getRequestedModifications", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedModifications(HttpServletRequest request,
			HttpServletResponse response) {

		GetModifications getModifications = new GetModifications();
		getModifications.setListRequestModi(centerPointService.getRequestedModifications());
		return getModifications;
	}

	@RequestMapping(value = "replyRequestedConfirmation", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedConfirmation(@RequestBody RequestedConfirmation requestBody,
			HttpServletRequest request, HttpServletResponse response) {

		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		centerPointService.replyRequestedConfirmations(requestBody.getDistrictId(), requestBody.isApproved(),
				userProfile.getLogin());
		return null;
	}

	@RequestMapping(value = "replyRequestedModification", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedModification(@RequestBody RequestedModification requestBody,
			HttpServletRequest request, HttpServletResponse response) {

		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		centerPointService.replyRequestedModifications(requestBody.getDistrictId(), requestBody.isApproved(),
				userProfile.getLogin());
		return null;
	}

}