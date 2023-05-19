package com.earth.rod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	WebApplicationContext servletAC;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
				
		ServletContext sc = request.getSession().getServletContext();
		WebApplicationContext rootAC = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		System.out.println("WebApplicationContext = " + rootAC);
		System.out.println("servletAC = " + servletAC);
		
		return "home";
	}
	
}
