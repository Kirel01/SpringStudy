package com.earth.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	// 로그인 화면
	@RequestMapping(value = "/loginpage")
	public String login() {
		return "loginForm";		
	}
	
	//메인 페이지 이동
	@RequestMapping(value = "/mainpage")
	public String main() {
		return "index";
	}
}
