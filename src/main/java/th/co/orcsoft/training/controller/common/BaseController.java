package th.co.orcsoft.training.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	protected String token = "toyza";
	
	public int getUserIdByHeader(HttpServletRequest request) {
		return Integer.parseInt(request.getHeader("userId"));
	}
	
	public boolean isOfficerByHeader(HttpServletRequest request) {
		return request.getHeader("role").toLowerCase().equals("officer");
	}
	
	public boolean isInvalidToken(HttpServletRequest request, HttpServletResponse response) {
		boolean isHeaderValidTokenValue = request.getHeader("token") != null;
		
		if (isHeaderValidTokenValue) {
			String requestToken = request.getHeader("token");
			if (requestToken.equals(token)) {
				return false;
			}
		}
		response.setStatus(401, "Invalid Token");
		return true;
	}
}
