package controllerM;

import java.io.IOException;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;


@WebServlet("/login")
public class C02_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C02_Login() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} //doGet


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청분석
		//=> 한글처리,request 의 Parameter 처리, 필요변수정의
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String uri="home.jsp";
		
		
		//2) Service &
		//=> id 확인
		// -> 존해하면 -> -password 비교 -> 일치: 성공 / 아니면 : 실패
		// -> 없으면 -> 실패
		// => 결과
		// -> 성공: home.jsp (Redirect)
		// -> 실패: 재로그인 유도 (loginForm.jsp)
		
	
		MemberService sservice = new MemberService();
		MemberDTO mdto = sservice.selectOne(id);
		if(mdto!=null && mdto.getPassword().equals(password)){
			//=>성공 : 로그인 정보 보관, home.jsp
			System.out.println("** 로그인 성공 **");
			request.getSession().setAttribute("loginID", id);
			request.getSession().setAttribute("loginName", mdto.getName());
			response.sendRedirect(uri);
		}else {
			//=>실패
			System.out.println("** 로그인 실패 **");
			request.setAttribute("message", "~~ 로그인 실패, 다시하세요 ~~");
			uri="member/loginForm.jsp";
			request.getRequestDispatcher(uri).forward(request, response);
		} 
		
		
		
	
	
	}//dopost
}
