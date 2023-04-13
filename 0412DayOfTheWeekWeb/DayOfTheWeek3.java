package com.earth.day;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 년,월,일 입력하면 해당 요일을 알려주는 프로그램을 정의하시오
 * 
 * 1) URL을 입력해서 호출을 하면 톰캣이 HttpServletRequest 객체를 만듬
 * 2) 브라우저에서 요청한 정보를 HttpServletRequest 객체에 담아서 자동으로 
 *    main()메서드의 매개변수로 넘겨줌
 */
@Controller			//1. 원격 호출 가능한 프로그램으로 등록
public class DayOfTheWeek3 {

	@RequestMapping("/getdayofweek")		//2. URL과 메서드를 연결
	public void main(HttpServletRequest request, HttpServletResponse response) {
		//1. 입력 
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		//2. 문자를 숫자로 바꿈
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd); 		// 날짜 세팅
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		// 요일 리턴
		
		/*
		 *  " 일월화수목금토".chatAt(1) => 일
		 *  " 일월화수목금토".chatAt(2) => 월
		 */
		
		 char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);
		 
		 //3. 출력
		 response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");	// 한글 정상 출력 목적
		 PrintWriter out;
		 
		 try {
			out = response.getWriter();		// 브라우저로의 출력 스트림 획득
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			
			out.println(year+ "년 "+ month +"월 "+ day+"일은");
			out.println(dayOfTheWeek + "요일입니다.");
			
			out.println("</body>");
			out.println("</html>");
		} catch (IOException e) {e.printStackTrace();}
	}
}
