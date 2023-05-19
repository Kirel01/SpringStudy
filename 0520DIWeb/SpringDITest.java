package com.earth.rod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car{}
class Engine{}
class Door {}

public class SpringDITest {

	public static void main(String[] args) {
		
		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		
		Car car = (Car) ac.getBean("car");				// byName 이름으로 검색
		Car car2 = ac.getBean("car", Car.class);		// byName 이름으로 검색
		Car car3 = ac.getBean(Car.class);				// byType 타입으로 검색
		
		Engine engine = (Engine) ac.getBean("engine");	// byName 이름으로 검색
		Engine engine2 = ac.getBean(Engine.class);		// byType 타입으로 검색
		Door door = (Door) ac.getBean("door");			// byName 이름으로 검색
		Door door2 = ac.getBean(Door.class);			// byType 타입으로 검색
		
		System.out.println("car = " + car);
		System.out.println("car2 = " + car2);
		System.out.println("car3 = " + car3);
		
		System.out.println("engine = " + engine);
		System.out.println("engine2 = " + engine2);
		System.out.println("door = " + door);
		System.out.println("door2 = " + door2);
	}
}
