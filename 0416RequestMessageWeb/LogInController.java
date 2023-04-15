package com.earth.car;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("logInController")
public class LogInController {

	@RequestMapping(value = { "/req/loginForm" }, method = { RequestMethod.POST })
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/requestMessage/loginForm");
		return mav;
	}

	@RequestMapping(value = "/req/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();

		String requestLine = request.getMethod(); // GET 또는 POST
		requestLine += " " + request.getRequestURI(); // /day/getdayofweek

		String queryString = request.getQueryString(); // ?year=2023&month=03%day=27
		requestLine += queryString == null ? "" : "?" + queryString;

		requestLine += " " + request.getProtocol();

		System.out.println(requestLine);

		// request header
		Enumeration<String> e = request.getHeaderNames();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + " : " + request.getHeader(name));
		}

		// request body -- POST일떄만 해당, GET은 body가 없음
		final int CONTENT_LENGTH = request.getContentLength();
		System.out.println("content length :" + CONTENT_LENGTH);

		if (CONTENT_LENGTH > 0) {

			try {
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/requestMessage/login");
				
				String userID = request.getParameter("userID");
				String userNAME = request.getParameter("userNAME");
				
				mav.addObject("userId", userID);
				mav.addObject("userNAME", userNAME);
				
				System.out.println();
				System.out.println("userID = "+userID+", userNAME = "+userNAME);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return mav;
	}

}
