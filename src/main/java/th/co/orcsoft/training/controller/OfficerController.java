package th.co.orcsoft.training.controller;

import java.util.ArrayList;
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
import th.co.orcsoft.training.common.db.service.OfficerService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.dashboard.response.NotCreatedDistrictsResponse;
import th.co.orcsoft.training.model.common.district.request.RequestCreateNewDistrictElection;
import th.co.orcsoft.training.model.common.district.request.RequestToModiRequest;
import th.co.orcsoft.training.model.common.district.response.ElectionDistrictsResponse;
import th.co.orcsoft.training.model.common.district.response.RequestedResponse;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;

@RestController
@RequestMapping(value = "/api/officer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OfficerController extends BaseController {

	@Autowired
	private OfficerService officerService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "createElectionDistinct", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel createElectionDistinct(@RequestBody RequestCreateNewDistrictElection requestBody, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		boolean isSucceed = officerService.createElectionDistrict(requestBody.getPrvId(), requestBody.getDistNum(), requestBody.getPty1Id(), requestBody.getPty1Vote(), requestBody.getPty2Id(), requestBody.getPty2Vote(), requestBody.getPty3Id(), requestBody.getPty3Vote(), requestBody.getBadVote(), requestBody.getVoteNo(), userProfile.getLogin());

		if (!isSucceed) {
			response.setStatus(400);
		}
		
		return null;
	}
	
	@RequestMapping(value = "updateElectionDistrict", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel updateElectionDistrict(@RequestBody RequestCreateNewDistrictElection requestBody, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		boolean isSucceed = officerService.updateElectionDistrict(requestBody.getPrvId(), requestBody.getDistNum(), requestBody.getPty1Id(), requestBody.getPty1Vote(), requestBody.getPty2Id(), requestBody.getPty2Vote(), requestBody.getPty3Id(), requestBody.getPty3Vote(), requestBody.getBadVote(), requestBody.getVoteNo(), userProfile.getLogin());

		if (!isSucceed) {
			response.setStatus(400);
		}
		
		return null;
	}
	
	@RequestMapping(value = "getElectionDistrictInfo", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getElectionDistricts(int districtId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		VoteModel electionPartyDistrict = officerService.getElectionDistrictInfo(districtId);
		
		if (electionPartyDistrict == null) {
			response.setStatus(400, "Data not found");
		}
		
		ElectionDistrictsResponse electionDistrictsResponse = new ElectionDistrictsResponse();
		electionDistrictsResponse.setVoteModel(electionPartyDistrict);
		return electionDistrictsResponse;
	}
	
	@RequestMapping(value = "requestToModifiedElectionResult", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel requestToModifiedElectionResult(@RequestBody RequestToModiRequest requestBody , HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		String updBy = userProfile.getLogin();
		
		boolean isSucceed = officerService.requestToModifiedElectionResult(requestBody.getDistrictId() , updBy);

		if (!isSucceed) {
			response.setStatus(400);
		}
		
		return null;
	}
	
	@RequestMapping(value = "getApprovedModifications", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getResultRequestedModifications(HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		RequestedResponse requestedResponse = new RequestedResponse();
		List<VoteModel> result = officerService.getApprovedModifications();
		requestedResponse.setVoteList(result);

		return requestedResponse;
	}
	
	@RequestMapping(value = "getPendingRequestedApproval", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		RequestedResponse requestedResponse = new RequestedResponse();
		List<VoteModel> result = officerService.getPendingRequestedApproval();
		requestedResponse.setVoteList(result);

		return requestedResponse;
	}
	
	@RequestMapping(value = "getNotCreatedDistrictsByProvince", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getNotApprovedDistrictsByProvince(int provinceId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		NotCreatedDistrictsResponse notCreatedDistrictsResponse = new NotCreatedDistrictsResponse();
		ArrayList<Integer> notApprovedDistrictList = officerService.getNotApprovedDistrictsByProvince(provinceId);
		notCreatedDistrictsResponse.setNotApprovedDistrictList(notApprovedDistrictList);
		
		return notCreatedDistrictsResponse;
	}
}
