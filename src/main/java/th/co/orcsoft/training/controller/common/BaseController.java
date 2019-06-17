package th.co.orcsoft.training.controller.common;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

	public int getUserIdByHeader(HttpServletRequest request) {
		return Integer.parseInt(request.getHeader("userId"));
	}

	public boolean isOfficerByHeader(HttpServletRequest request) {
		return request.getHeader("role").toLowerCase().equals("officer");
	}
}
