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
import th.co.orcsoft.training.common.db.service.CenterService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.center.request.RequestedConfirmation;
import th.co.orcsoft.training.model.common.center.request.RequestedModification;
import th.co.orcsoft.training.model.common.center.response.RequestedApprovalsResponse;
import th.co.orcsoft.training.model.common.center.response.RequestedModificationsResponse;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;

@RestController
@RequestMapping(value = "/api/center")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CenterController extends BaseController {

	@Autowired
	private CenterService centerService;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "getRequestedApprovals", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request,
			HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		RequestedApprovalsResponse requestedApprovalsResponse = new RequestedApprovalsResponse();
		List<VoteModel> requestApprovals = centerService.getRequestedApprovals();
		requestedApprovalsResponse.setListRequestCon(requestApprovals);

		return requestedApprovalsResponse;
	}

	@RequestMapping(value = "getRequestedModifications", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedModifications(HttpServletRequest request,
			HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		RequestedModificationsResponse requestedModificationsResponse = new RequestedModificationsResponse();
		requestedModificationsResponse.setListRequestModi(centerService.getRequestedModifications());
		return requestedModificationsResponse;
	}

	@RequestMapping(value = "replyRequestedApproval", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedApproval(@RequestBody RequestedConfirmation requestBody,
			HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		boolean isSucceed = centerService.replyRequestedApproval(requestBody.getDistrictId(), requestBody.isApproved(), userProfile.getLogin());
		
		if (!isSucceed) {
			response.setStatus(400);
		}
		
		return null;
	}
	
	@RequestMapping(value = "replyRequestedModification", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel replyRequestedModification(@RequestBody RequestedModification requestBody,
			HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = this.authService.getUserProfile(userId);
		boolean isSucceed = centerService.replyRequestedModification(requestBody.getDistrictId(), requestBody.isApproved(), userProfile.getLogin());
		
		if (!isSucceed) {
			response.setStatus(400);
		}
		
		return null;
	}
	
}