package com.earth.moon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {

	@RequestMapping("/rollDice")
	public void moon(HttpServletResponse response) {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		
		int a = (int) (Math.random()*6)+1;
		int b = (int) (Math.random()*6)+1;
		
		try {
			out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<img src='resources/img/dice"+a+".jpg' />");
			out.println("<img src='resources/img/dice"+b+".jpg' />");
			out.println("</body>");			
			out.println("</html>");
			
			new Throwable();
			
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
