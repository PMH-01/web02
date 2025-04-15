package controllerF;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

public class Ex05_mList implements Ex04_Controller{

	@Override
	public String doUesr(HttpServletRequest request, HttpServletResponse response) {
		MemberService mservice = new MemberService();
		request.setAttribute("mlist", mservice.selectList());
		return "member/memberList.jsp";
	}

}
