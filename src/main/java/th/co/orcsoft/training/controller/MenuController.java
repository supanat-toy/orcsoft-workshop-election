package th.co.orcsoft.training.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

	@GetMapping(value = "getStringMsg")
	public String getStringMsg() {
		return "Message in th.co.orcsoft.training.controller.MenuController.getStringMsg()";
	}
}
