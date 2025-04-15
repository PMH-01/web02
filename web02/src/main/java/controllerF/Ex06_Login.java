package controllerF;

import domain.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class Ex06_Login implements Ex04_Controller{
	
	@Override
	public String doUesr(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String uri="home.jsp";
		
		MemberService sservice = new MemberService();
		MemberDTO mdto = sservice.selectOne(id);
		
		request.setAttribute("mdto", sservice.selectOne(id));
		if(mdto!=null && mdto.getPassword().equals(password)){
			//=>성공 : 로그인 정보 보관, home.jsp
			System.out.println("** 로그인 성공 **");
			request.getSession().setAttribute("loginID", id);
			request.getSession().setAttribute("loginName", mdto.getName());
		}else {
			//=>실패
			System.out.println("** 로그인 실패 **");
			request.setAttribute("message", "~~ 로그인 실패, 다시하세요 ~~");
			uri="member/loginForm.jsp";
		}
		return uri; 
	}
	
}
