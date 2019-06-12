package th.co.orcsoft.training.controller.common;

import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	public int getUserIdByHeader(HttpServletResponse response) {
		return Integer.parseInt(response.getHeader("userId"));
	}
	
	public boolean isOfficerByHeader(HttpServletResponse response) {
		return response.getHeader("role").toLowerCase().equals("officer");
	} 
}
