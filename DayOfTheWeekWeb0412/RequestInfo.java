package com.earth.day;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestInfo {

	@RequestMapping("/requestInfo")
	public void main(HttpServletRequest request) {
		System.out.println(request.getCharacterEncoding());	// 요청 내용에 대한 인코딩 방식, 알 수 없을 때는 null
		System.out.println(request.getContentLength());		// 요청 내용의 길이, 알 수 없을 때는 -1
		System.out.println(request.getContentType());		// 요청 내용의 타입, 알 수 없을 때는 null
		System.out.println(request.getMethod()); 			// 요청 방법 , get
		System.out.println(request.getProtocol()); 			// 프로토콜의 종류와 버젼
		System.out.println(request.getScheme()); 			// 프로토콜
		
		System.out.println(request.getServerName()); 		// 서버 이름 or IP주소
		System.out.println(request.getServerPort()); 		// 서버 포트
		System.out.println(request.getRequestURL());		// 요청 URL
		System.out.println(request.getRequestURI()); 		// 요청 URI
		System.out.println(request.getContextPath());		// ContextPath
		
		System.out.println(request.getServletPath()); 		// ServletPath - 서버 프로그램에 대한 Path 
		System.out.println(request.getQueryString()); 		// 쿼리 스트링
		
		System.out.println(request.getLocalName());			// 로컬 이름
		System.out.println(request.getLocalPort());			// 로컬 포트
		
		System.out.println(request.getRemoteAddr());		// 원격 ip 주소
		System.out.println(request.getRemoteHost());		// 원격 호스트 또는 ip 주소
		System.out.println(request.getRemotePort());		// 원격 포트
	}
}
