package com.earth.remote;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall { 

	public static void main(String[] args) {
		Hello hello = new Hello();
		// hello.main(); // private 이라 외부 호출 불가
		
		try {
			//Hello 클래스의 Class 객체(클래스의 정보를 담고 있는 객체)를 얻어옴
			Class helloClass = Class.forName("com.earth.remote.Hello");
			//Class 객체가 가진 정보로 객체 생성
			Hello hello2 = (Hello) helloClass.newInstance();
			
			Method main = helloClass.getDeclaredMethod("main");
			
			//private인 main()을 접근가능하게 함
			main.setAccessible(true);
			main.invoke(hello2);		// hello.main() 과 동일
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {e.printStackTrace();}
	}
}
