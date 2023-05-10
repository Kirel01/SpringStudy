package com.earth.di5_2;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

/*
 *  빈(Bean)
 *  	1) Spring (IoC) Container가 관리하는 객체
 *  	2) ApplicationContext가 담고 있는 객체
 *  	3) 일반적인 객체 생성 방법으로 만든 객체는 bean이 아님
 */

/*
 * 	5. 객체를 자동 연결하기
 * 		- @Autowired : Type으로 찾음 (Value)
 * 		- @Resourced : Name으로 찾음 (Key)
 */
@Component
class Car {
//	@Autowired
//	Engine engine;
//	@Autowired
//	Door door;

	@Resource(name = "engine")
	Engine engine;
	@Resource Door door;
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", door=" + door + "]";
	}

}

@Component
class SuvCar extends Car {}
@Component
class ElectronCar extends Car {}
@Component
class Engine {
}

@Component
class Door {
}

// 변경에 유리한 코드
// ApplicationContext 정의
class AppContext {
	Map map; // 객체 저장소 (key-value 형식, car - 0x100....)

	public AppContext() throws IllegalArgumentException, IllegalAccessException {
		// 3. 자동으로 객체 등록()
		// @Component 어노테이션이 설정된 클래스들을 Set에 저장한 뒤 이를 통해 Bean을 생성
		map = new HashMap();
		doComponentScan();
		doAutowired();
		doResource();
	}

	private void doResource() {
		// TODO Auto-generated method stub
		
	}

	private void doAutowired() throws IllegalArgumentException, IllegalAccessException {
		// map에 저장된 객체의 인스턴스 변수에 @Resource가 붙어 있으면
		// map에서 인스턴스 변수의 타입에 맞는 개게를 찾아서 연결(객체의 주소를 변수에 저장) --Name으로 찾음(key)

		for (Object bean : map.values()) {
			for (Field fld : bean.getClass().getDeclaredFields()) {
				if (fld.getAnnotation(Resource.class) != null) // byName
					fld.set(bean, getBean(fld.getName())); // car.engine = engine
			}
		}

	}

	private void doComponentScan() {

		/*
		 * 1) 패키지 내의 클래스 목록을 가져옴 2) 반복문으로 클래스를 읽으면서 @Component가 붙어있는지 확인 3) @Component가
		 * 붙어있을 경우 객체를 생성, map에 저장
		 */

		ClassLoader classLoader = AppContext.class.getClassLoader();
		try {
			ClassPath classPath = ClassPath.from(classLoader);
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.earth.di5_2");

			for (ClassPath.ClassInfo classInfo : set) {
				Class clazz = classInfo.load();
				Component component = (Component) clazz.getAnnotation(Component.class);
				if (component != null) {
					String id = StringUtils.uncapitalize(classInfo.getSimpleName());
					map.put(id, clazz.newInstance());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 객체 찾기 - by Name, by Type
	 */

	// 이름으로 찾기 - by Name
	public Object getBean(String key) {
		return map.get(key);
	}

	// 타입으로 찾기 - by Type (instanceof)
	public Object getBean(Class clazz) {
		for (Object obj : map.values()) {
			if (clazz.isInstance(obj)) // obj가 결국 instanceof clazz
				return obj;
		}
		return null;
	}

}

// 변경에 유리한 코드
public class SpringDIIntro {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		AppContext ac = new AppContext();
		Car car = (Car) ac.getBean("car"); // by Name으로 객체를 검색
		Car car2 = (Car) ac.getBean(Car.class); // by Type으로 객체를 검색
		Engine engine = (Engine) ac.getBean("engine"); // by Name으로 객체를 검색

		Door door = (Door) ac.getBean(Door.class); // by Type으로 객체를 검색

		// 객체 참조 (연결)
		// car.engine = engine;
		// car.door = door;

		System.out.println("car = " + car);
		System.out.println("engine = " + engine);
		System.out.println("door =" + door);
	}
}
