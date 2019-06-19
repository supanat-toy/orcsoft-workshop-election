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
import th.co.orcsoft.training.common.db.service.DistrictService;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.district.request.RequestCreateNewDistrictElection;
import th.co.orcsoft.training.model.common.district.request.RequestToModiRequest;
import th.co.orcsoft.training.model.common.district.response.GetElectionDistricts;
import th.co.orcsoft.training.model.common.district.response.GetResultRequestedModiResponse;
import th.co.orcsoft.training.model.db.UsersModel;
import th.co.orcsoft.training.model.db.VoteModel;

@RestController
@RequestMapping(value = "/api/district")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistrictController extends BaseController {

	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "createElectionDistinct", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel createElectionDistinct(@RequestBody RequestCreateNewDistrictElection requestBody, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		districtService.createElectionDistrict(requestBody.getPrvId(), requestBody.getDistNum(), requestBody.getPty1Id(), requestBody.getPty1Vote(), requestBody.getPty2Id(), requestBody.getPty2Vote(), requestBody.getPty3Id(), requestBody.getPty3Vote(), requestBody.getBadVote(), requestBody.getVoteNo(), userProfile.getLogin());

		return new AbsResponseModel() {};
	}
	
	@RequestMapping(value = "updateElectionDistrict", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel updateElectionDistrict(@RequestBody RequestCreateNewDistrictElection requestBody, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		districtService.updateElectionDistrict(requestBody.getPrvId(), requestBody.getDistNum(), requestBody.getPty1Id(), requestBody.getPty1Vote(), requestBody.getPty2Id(), requestBody.getPty2Vote(), requestBody.getPty3Id(), requestBody.getPty3Vote(), requestBody.getBadVote(), requestBody.getVoteNo(), userProfile.getLogin());

		return null;
	}
	
	@RequestMapping(value = "getElectionDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getElectionDistricts(int districtId, HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		VoteModel electionPartyDistricts = districtService.getElectionDistrictInfo(districtId);
		
		if (electionPartyDistricts == null) {
			response.setStatus(400, "Data not found");
		}
		
		GetElectionDistricts getElectionDistricts = new GetElectionDistricts();
		getElectionDistricts.setVoteModel(electionPartyDistricts);
		return getElectionDistricts;
	}
	
	@RequestMapping(value = "requestToModifiedElectionResult", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel requestToModifiedElectionResult(@RequestBody RequestToModiRequest requestBody , HttpServletRequest request, HttpServletResponse response) {
		
		if (isInvalidToken(request, response)) {
			return null;
		}
		
		int userId = this.getUserIdByHeader(request);
		UsersModel userProfile = authService.getUserProfile(userId);
		String updBy = userProfile.getLogin();
		
		districtService.requestToModifiedElectionResult(requestBody.getDistrictId() , updBy);

		return null;
	}
	
	@RequestMapping(value = "getResultRequestedModifications", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getResultRequestedModifications(HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		GetResultRequestedModiResponse getResultRequestedModifications = new GetResultRequestedModiResponse();
		getResultRequestedModifications.setVoteList(districtService.getResultRequestModifications());

		return getResultRequestedModifications;
	}
	
	@RequestMapping(value = "getResultRequestedConfirmations", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getRequestedConfirmations(HttpServletRequest request, HttpServletResponse response) {

		if (isInvalidToken(request, response)) {
			return null;
		}
		
		GetResultRequestedModiResponse getResultRequestedModifications = new GetResultRequestedModiResponse();
		List<VoteModel> result = districtService.getResultRequestedConfirmations();
		getResultRequestedModifications.setVoteList(result);

		return getResultRequestedModifications;
	}
}
