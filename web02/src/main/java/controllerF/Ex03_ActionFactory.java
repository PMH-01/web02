package controllerF;

import java.util.*;

//** ActionFactory
//=> FrontController가 요청한 컨트롤러 클래스를 생성해서 제공
//=> 즉, Java객체 (Bean)을 공급하는 역할, BeanFactory라함

//** Factory 객체 단일 생성 권장
//=> 인스턴스를 1개만 생성하도록 구현
//=> 이렇게 인스턴스를 1개만 허용하는 방식을 싱글톤 패턴 이라함

//** 싱글톤 패턴
//=> 클래스 외부에서는 인스턴스를 생성할 수 없도록 제한
//=> 방법
//	- 생성자를 private으로 내부에서만 사용 가능하도록
//	- 내부에서 생성 공급: getInstance() 메서드로
//	- 외부에서는 getInstance() 메서드를 통해서만 사용

public class Ex03_ActionFactory {
	//** Map 적용
	//=> 정의
	//=> 생성시에 Data 저장(put)
	private Map<String, Ex04_Controller> mappings;
		

	//** 싱글톤 패턴을 위한 생성자 정의
	private Ex03_ActionFactory() {
		mappings = new HashMap<String, Ex04_Controller>();
		mappings.put("/mlist.do", new Ex05_mList());
		mappings.put("/mdetail.do", new Ex05_mDetail());
		mappings.put("/login.do", new Ex06_Login());
		mappings.put("/logout.do", new Ex06_Logout());
	}
	
	private static Ex03_ActionFactory instance = new Ex03_ActionFactory();
	public static Ex03_ActionFactory getInstance() {
		return instance;
	}
	
	//** FrontController의 요청에 해당하는 Bean 생성 & 공급
	public Ex04_Controller getController(String mappingName) {
		//1) if 적용
		/*if("/mlist.do".equals(mappingName)) {
			return new Ex05_mList();
		}else if("/mdetail.do".equals(mappingName)) {
			return new Ex05_mDetail();
		}else {
			return null;			
		}*/
	
	//2) Map 적용
		return mappings.get(mappingName);
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
