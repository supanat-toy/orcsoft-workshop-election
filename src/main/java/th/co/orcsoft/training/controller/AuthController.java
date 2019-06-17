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
import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;
import th.co.orcsoft.training.model.common.auth.request.RequestAuthorization;
import th.co.orcsoft.training.model.common.auth.response.GetAuthorization;
import th.co.orcsoft.training.model.db.UsersModel;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController extends BaseController {

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "authorization", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public @ResponseBody AbsResponseModel authorization(@RequestBody RequestAuthorization requestAuthorization,
			HttpServletRequest request, HttpServletResponse response) {

		GetAuthorization getAuthorization = new GetAuthorization();

		UsersModel user = authService.login(requestAuthorization.getUsername(), requestAuthorization.getPassword());
		getAuthorization.setUser(user);
		return getAuthorization;
	}

	@RequestMapping(value = "getProfile", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getProfile(HttpServletRequest request, HttpServletResponse response) {

		GetAuthorization getAuthorization = new GetAuthorization();

		int userId = this.getUserIdByHeader(request);
		UsersModel user = authService.getUserProfile(userId);
		getAuthorization.setUser(user);
		return getAuthorization;
	}
}
