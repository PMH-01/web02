package controllerF;

//** FrontController 패턴2
//=> Factory 패턴 적용
//	- ActionFactory
//	- 개별동작을 처리하는 컨트롤러
//	- 일관성 있는 처리를 위해 강제적 규칙 필요(interface 사용)

//** 실습
//=> login.dom logout.do 추가
//=> home.jsp loginForm.jsp 요청명 수정
//=> ActionFactory의 map에 매핑해주기
//=> controller Ex06_Login.java, Ex06_Logout.java  추가

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= {"*.do"})
public class Ex02_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청분석
		//=> url 분석 후 요청명 확인
		String uri = request.getServletPath();
	
		//2. Service 실행
		//=> 필요한 객체를 Factory에 요청
		//=> Factory는 요청받은 객체(service controller)를 생성해 인스턴스를 제공 
		
		//=> Factory 생성: 싱글턴
		//Ex03_ActionFactory action = new Ex03_ActionFactory(); -> 불가능
		//=> 싱글턴 확인
		//Ex03_ActionFactory test1 = Ex03_ActionFactory.getInstance();
		//Ex03_ActionFactory test2 = Ex03_ActionFactory.getInstance();
		
		Ex03_ActionFactory action = Ex03_ActionFactory.getInstance();
		//System.out.printf("싱글턴 확인: test1=%s, test2=%s, action=%s \n", test1,test2,action);
		Ex04_Controller controller = action.getController(uri);// 다형성
		uri = controller.doUesr(request, response);
		
		//3. View 처리
		if(uri.contains("home.jsp")) {
			response.sendRedirect(uri);
		}else
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
