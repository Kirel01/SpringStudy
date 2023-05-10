package com.earth.di;

import java.util.HashMap;
import java.util.Map;

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

// ApplicationContext 정의
class AppContext {
	Map map;	//객체 저장소 (key-value 형식, car - 0x100....)
	public AppContext() {
		// 1. 하드코딩
		map = new HashMap();
		map.put("car", new SuvCar());
		map.put("engine", new Engine());
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
