package th.co.orcsoft.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import th.co.orcsoft.training.common.db.service.AuthService;
import th.co.orcsoft.training.common.db.service.PartyService;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.auth.response.GetAuthorization;
import th.co.orcsoft.training.model.common.party.response.GetAllPartyResponse;
import th.co.orcsoft.training.model.db.UsersModel;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "authorization", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel authorization(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		
		GetAuthorization getAuthorization = new GetAuthorization();
		
		UsersModel user = authService.login(username, password);
		getAuthorization.setUser(user);
		return getAuthorization;
	}
}
