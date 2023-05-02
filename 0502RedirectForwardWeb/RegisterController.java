package com.earth.sunny;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	//@RequestMapping(value = "/register/add2")
	@RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
	//@GetMapping("/register/add")
	public String register() {
		return "registerForm";		// 신규 회원의 가입 화면 
	}
	
	//@RequestMapping(value = "/register/save2")
	@PostMapping("/register/save")
	public String save(User user, Model m) throws UnsupportedEncodingException {
		// 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.", "utf-8");
			//return "redirect:/register/add?msg="+msg;
			return "forward:/register/add";
		}
		
		return "registerinfo";
	}

	private boolean isValid(User user) {
		
		return false;
	}
}
