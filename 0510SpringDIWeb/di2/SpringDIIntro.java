package com.earth.di2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 *  빈(Bean)
 *  	1) Spring (IoC) Container가 관리하는 객체
 *  	2) ApplicationContext가 담고 있는 객체
 *  	3) 일반적인 객체 생성 방법으로 만든 객체는 bean이 아님
 */
class Car {}
class SuvCar extends Car {}
class ElectronCar extends Car {}
class Engine {}

// 변경에 유리한 코드
// ApplicationContext 정의
class AppContext {
	Map map;	//객체 저장소 (key-value 형식, car - 0x100....)
	public AppContext() {
		// 2. txt파일만 바꾸면 메서드나 내부 소스를 안 바꾸고 원하는 결과 출력시킬 수 있음
		Properties p = new Properties();
		try {
			p.load(new FileReader("config.txt"));
			
			// properties에 저장된 내용을 map에 저장
			map = new HashMap(p);
			// 클래스 이름의 객체로 변환해서 Map에 저장
			for(Object key : map.keySet()) {
				Class clazz = Class.forName((String) map.get(key));
				map.put(key, clazz.newInstance());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getBean(String key) {
		return map.get(key);
	}
}

// 변경에 유리한 코드
public class SpringDIIntro {

	public static void main(String[] args) {
		AppContext ac = new AppContext();
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		
		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
	}
}
