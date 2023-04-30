package com.earth.ai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/*
 * 컨트롤러 매개변수
 * 		1) 기본형, String일 때는 @RequestParam이 생략된 상태
 * 		2) 참조형일 경우에는 @ModelAttribute가 생략된 상태
 */
@Controller			//1. 원격 호출 가능한 프로그램으로 등록
public class DayOfTheWeek3 {

	// MyDate 클래스의 매개변수를 선언. getter, setter 작성해야 함
	@RequestMapping("/getdaymvc3")		//2. URL과 메서드를 연결
	public String main(@ModelAttribute("myDate") MyDate date, Model model) {
	 
		//1. 유효성 검사
		if (!isValid(date))
			return "dayOfWeekError";	// /WEB-INF/views/dayOfWeekError.jsp+
	
		//2. 요일 계산
		//char dayOfTheWeek = getDayOfWeek(date);
		 
		//3. Model에 작업 결과 저장
		 
		//model.addAttribute("mydate", date);
		//model.addAttribute("dayOfTheWeek", dayOfTheWeek);
		 
		return "dayOfWeek2";
		//jsp 파일(뷰)이 없을 떄는 @RequestMapping() 에서 설정한 url과 동일한 파일을 찾게 됨
	}

	// 메서드 반환타입 앞에 @ModelAttribute 사용
	private @ModelAttribute("dayOfTheWeek") char getDayOfWeek(MyDate date) {
		// TODO Auto-generated method stub
		return getDayOfWeek(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getDayOfWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day); 		// 날짜 세팅
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);
		return dayOfTheWeek;
	}

	private boolean isValid(int year, int month, int day) {
		if(year == -1 || month == -1 || day == -1)
			return false;
		return (month >=1 && month <= 12) && (day >=1 && day <=31);
		
	}
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		return "dayOfWeekError";
	}
}
