package com.earth.ai;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamTest {
	
	@RequestMapping("/requestParam")
	/*
	 * http://localhost/ai/requestParam			---> year=null
	 * http://localhost/ai/requestParam?year=	---> year=""
	 * http://localhost/ai/requestParam?year	---> year=""
	 */
	public String earth(HttpServletRequest request) {
		String year = request.getParameter("year");
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";
	}
	
	@RequestMapping("/requestParam2")
	//public String earth(String year) { // 아래와 동일함
	public String earth2(@RequestParam(name="year", required = false) String year) {
		/*
		 * http://localhost/ai/requestParam2		---> year=null
		 * http://localhost/ai/requestParam2?year	---> year=""
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";		
	}
	@RequestMapping("/requestParam3")
	//public String earth3(@RequestParam String year) {
	public String earth3(@RequestParam(name="year", required = true) String year) {
		/*
		 * http://localhost/ai/requestParam3 		---> 400error - 클라이언트 오류, required = true 때문에 year값이 있어야 함
		 * http://localhost/ai/requestParam3?year 	---> year=""
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	@RequestMapping("/requestParam4")
	public String earth4(@RequestParam(required = false) String year) {
		/*
		 * http://localhost/ai/requestParam4 		---> year=null
		 * http://localhost/ai/requestParam4?year 	---> year="" 
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	@RequestMapping("/requestParam5")
	public String earth5(@RequestParam(required = false, defaultValue = "2023") String year) {
		/*
		 * http://localhost/ai/requestParam5 		---> year=2023
		 * http://localhost/ai/requestParam5?year 	---> year=2023 
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	
	//==========================================================================================
	
	@RequestMapping("/requestParam6")
	public String earth6(int year) {
		/*
		 * http://localhost/ai/requestParam6 		---> 500error - 내부 서버 오류 
		 * http://localhost/ai/requestParam6?year	---> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}	
	// 예외처리
	// 컨트롤러의 모든 예외가 발생했을 시 dayOfWeekError.jsp 파일이 화면에 리턴
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		return "dayOfWeekError";
	}
	@RequestMapping("/requestParam7")
	public String earth7(@RequestParam int year) {
		/*
		 * http://localhost/ai/requestParam7 		---> 400 Bad Request, Required int parameter 'year' is not present
		 * http://localhost/ai/requestParam7?year	---> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	@RequestMapping("/requestParam8")
	public String earth8(@RequestParam(required = false) int year) {
		/*
		 * http://localhost/ai/requestParam8 		---> 500 IllegalStateException: Optional int parameter 'year' is present but cannot be translated into a null value due to being declared as a primitive type.
		 * http://localhost/ai/requestParam8?year	---> 400 Bad Request, nested exception is java.lang.NumberFormatException: For input string: ""
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	@RequestMapping("/requestParam9")
	public String earth9(@RequestParam(required = true, defaultValue = "2023") int year) {
		/*
		 * http://localhost/ai/requestParam9 		---> year=2023
		 * http://localhost/ai/requestParam9?year	---> year=2023
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
	@RequestMapping("/requestParam10")
	public String earth10(@RequestParam(required = true, defaultValue = "1") int year) {
		/*
		 * http://localhost/ai/requestParam10 		---> year=1
		 * http://localhost/ai/requestParam10?year	---> year=1
		 */
		System.out.printf("[%s]year=[%s]%n", new Date(), year);
		return "dayOfWeek";	
	}
		
	
}
