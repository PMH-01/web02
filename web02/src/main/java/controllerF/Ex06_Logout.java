package controllerF;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex06_Logout implements Ex04_Controller{
	
	@Override
	public String doUesr(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		System.out.println("로그아웃 되었습니다");

		return "home.jsp";
	}
}
