package controllerM;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class C02_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C02_Logout() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청분석
		String uri="home.jsp";

		//2. Service & 결과(저장 & forward)
		//=> session 무효화
		request.getSession().invalidate();
		System.out.println("로그아웃 되었습니다");

		response.sendRedirect(uri);


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
