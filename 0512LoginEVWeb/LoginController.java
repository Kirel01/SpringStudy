package com.earth.loginevweb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	@PostMapping("/login")	//위는 get, 이거슨 post 방식이니까 url이 겹쳐도 상관없다.
	public String login(String id, String pwd, String toURL, boolean rememberId,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// 1. id와 pw를 확인
		if(!loginCheck(id,pwd)) {
			// * 2-1. 일치하지 않으면 loginForm으로 이동
			String msg= URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		// * 2-2. 일치하면 로그인 후 화면(홈화면) 으로 이동
		// * 
		// * 2-2-1. 쿠키 생성
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
		// * 2-2-2. 응답헤더에 저장
			response.addCookie(cookie);
		}
		else {
			// * 2-3-1. 쿠키 삭제
			// * 2-3-2. 응답헤더에 저장
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		//3. 세션 객체 얻어오기
		HttpSession session = request.getSession();
		
		session.setAttribute("id", id);
		
		//4.뷰 이동
		toURL = toURL==null|| toURL.equals("") ? "/" : toURL ;
		return "redirect:" + toURL;
	}
	private boolean loginCheck(String id, String pwd) {
		return "withdang".equals(id) && "0000".equals(pwd);
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	//세션 종료
		return "redirect:/";
	}

}
