package com.earth.duststorm;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice("com.earth/duststorm2")	// 패키지명을 지정하면 지정된 패키지에서 발생한 예외만 처리
@ControllerAdvice 	// 모든 컨트롤러에서 발생하는 예외를 다 처리하게 됨(모든 패키지에 적용)
public class SharedCatcher {

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in SharedCatcher");
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		return "error";
	}
}
