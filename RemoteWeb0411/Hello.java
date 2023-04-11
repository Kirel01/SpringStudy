package com.earth.remote;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	int iv = 10;	// 인스턴스 변수
	static int cv = 20;		// static 변수
	
	//2. URL과 메서드를 연결
	/*
	 *  톰캣에서 객체를 만들어주기 때문에 메서드가 static인지 아닌지 상관 없음
	 *  접근제어자 private, public 등 상관없이 외부에서 호출이 가능
	 *  - 왜냐하면 reflection api를 사용하기 때문에
	 */
	@RequestMapping("/hello")
	private void main() {
		System.out.println("Hello - private");	// 인스턴스 메서드 - 인스턴스 변수,
		System.out.println(iv);
		System.out.println(cv);
	}
	
}
