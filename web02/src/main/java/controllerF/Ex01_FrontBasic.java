package controllerF;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

import java.io.IOException;

import domain.MemberDTO;

//** FrontController 패턴1.
//=> 대표컨트롤러 1개만 서블릿으로 작성
//	 모든 요청을 이 대표 컨트롤러(FrontController)가 받고록 함.
//	 각 요청별 작업들은 일반 클래스로 작성

//@WebServlet(urlPatterns= {"*.do"})
public class Ex01_FrontBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex01_FrontBasic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청분석
		//=> url 분석 후 요청명 확인
		String uri = request.getServletPath();
		System.out.println("** requset.getServletPath() => "+uri);
		System.out.println("** request.getRequestURL() => "+request.getRequestURL());
		System.out.println("** request.getRequestURI() => "+request.getRequestURI());
		
		//2. Service 실행
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		
		if("/mlist.do".equals(uri)) {
			//=> MemberList
			request.setAttribute("mlist", service.selectList());
			uri="member/memberList.jsp";
		}else if("/mdetail.do".equals(uri)){
			//=> login 후 Test
			String id = (String)request.getSession().getAttribute("loginID");
			request.setAttribute("mdto", service.selectOne(id));
			uri="member/memberDetail.jsp";
		}else {
			request.setAttribute("message", "없는 요청 입니다");
			uri="home.jsp";
		}
				
		//3. View 처리
		request.getRequestDispatcher(uri).forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
