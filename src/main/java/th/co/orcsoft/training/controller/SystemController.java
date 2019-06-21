package th.co.orcsoft.training.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.orcsoft.training.controller.common.BaseController;
import th.co.orcsoft.training.model.common.AbsResponseModel;

@RestController
@RequestMapping(value = "/api/system")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SystemController extends BaseController {
	
	@RequestMapping(value = "check", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public @ResponseBody AbsResponseModel getTest(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(200);
		
		return null;
	}
}
