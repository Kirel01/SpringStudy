package com.earth.sun;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeader {

	@RequestMapping("/requestheader")
	public void apple(HttpServletRequest request) {
	
		Enumeration<String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name +" : "+ request.getHeader(name));
		}
	}
}
