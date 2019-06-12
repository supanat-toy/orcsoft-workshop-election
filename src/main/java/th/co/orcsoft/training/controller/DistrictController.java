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
import th.co.orcsoft.training.common.db.dao.AuthDao;
import th.co.orcsoft.training.common.db.service.DistrictService;
import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.common.db.service.impl.AuthServiceImpl;
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.district.response.GetElectionDistricts;
import th.co.orcsoft.training.model.common.district.response.GetResultRequestedModiResponse;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;
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
	public @ResponseBody AbsResponseModel createElectionDistinct(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id, int pty3Vote, double badVote, double voteNo, HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		UsersModel userProfile = authService.getUserProfile(userId);
		districtService.createElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote, badVote, voteNo, userProfile.getLogin());

		return new AbsResponseModel() {};
	}
	
	@RequestMapping(value = "updateElectionDistrict", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel updateElectionDistrict(int prvId, int distNum, int pty1Id, int pty1Vote, int pty2Id, int pty2Vote, int pty3Id, int pty3Vote, double badVote, double voteNo, HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		AuthServiceImpl authServiceImpl = new AuthServiceImpl();
		UsersModel usersModel = authServiceImpl.getUserProfile(userId);
		districtService.updateElectionDistrict(prvId, distNum, pty1Id, pty1Vote, pty2Id, pty2Vote, pty3Id, pty3Vote, badVote, voteNo, usersModel.getLogin());

		return null;
	}
	
	@RequestMapping(value = "getElectionDistricts", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getElectionDistricts(int districtId, HttpServletRequest request, HttpServletResponse response) {
		
		VoteModel electionPartyDistricts = districtService.getElectionDistrictInfo(districtId);
		GetElectionDistricts getElectionDistricts = new GetElectionDistricts();
		getElectionDistricts.setVoteModel(electionPartyDistricts);
		return getElectionDistricts;
	}
	
	@RequestMapping(value = "requestToModifiedElectionResult", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel requestToModifiedElectionResult(int districtId, HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		AuthService user = new AuthServiceImpl();
		UsersModel userProfile = user.getUserProfile(userId);
		String updBy = userProfile.getLogin();
		
		districtService.requestToModifiedElectionResult(districtId,updBy);

		return null;
	}
	
	@RequestMapping(value = "getResultRequestedModifications", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getResultRequestedModifications(HttpServletRequest request, HttpServletResponse response) {
		
		int userId = this.getUserIdByHeader(response);
		
		GetResultRequestedModiResponse getResultRequestedModifications = new GetResultRequestedModiResponse();
		getResultRequestedModifications.setVoteList(districtService.getResultRequestModifications());

		return getResultRequestedModifications;
	}
}
