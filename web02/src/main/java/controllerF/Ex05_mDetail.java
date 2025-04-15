package controllerF;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class Ex05_mDetail implements Ex04_Controller{

	@Override
	public String doUesr(HttpServletRequest request, HttpServletResponse response) {
		
		String id = (String)request.getSession().getAttribute("loginID");
		MemberService mservice = new MemberService();
		request.setAttribute("mdto",mservice.selectOne(id));
		return "member/memberDetail.jsp";
	}
}
