package com.earth.finedust;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
class MyException extends RuntimeException{
	public MyException(String msg) {
		super(msg);
	}
	
	public MyException() {
		this("");
	}
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class MyException2 extends RuntimeException{
	public MyException2(String msg) {
		super(msg);
	}
	
	public MyException2() {
		this("");
	}
}


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/test")
	public String earth(Model m) {
		throw new MyException("사용자 정의 예외가 발생했습니다.");
	}
	
	@RequestMapping("/test2")
	public String earth2(Model m) {
		throw new MyException2("사용자 정의 예외가 발생했습니다.");
	}
	
	@RequestMapping("/test3")
	public String earth3(Model m) throws Exception {
		throw new Exception("사용자 정의 예외가 발생했습니다.");
	}
	
	@RequestMapping("/test4")
	public String earth4(Model m) throws Exception {
		throw new FileNotFoundException("사용자 정의 예외가 발생했습니다.");
	}
}
