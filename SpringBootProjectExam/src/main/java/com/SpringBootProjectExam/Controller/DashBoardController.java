package com.SpringBootProjectExam.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
	@GetMapping("/getDashboard")
	public String getYourDash() {
		return "dashboard";
	}
}