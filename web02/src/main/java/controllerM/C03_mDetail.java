package controllerM;

import java.io.IOException;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;


@WebServlet("/mdetail")
public class C03_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C03_mDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청분석
		//=> id 필요함 (session 에 보관해놓은 id 사용)
		String id=(String)request.getSession().getAttribute("loginID");
		String uri="member/memberDetail.jsp";
		System.out.println(id);
		
		//=> Update 요청인 경우 uri를 "member/updateForm.jsp"
		//=> 주의사항: jCode가 없을때는 null값을 return함
		//	 nullPointException 오류 예방위한 코드가 필요함
		///	 (아래 처럼 null이 될 수 없는 리터럴에 equals 적용)
		//if(request.getParameter("jCode").equals("U")) {
		if("U".equals(request.getParameter("jCode"))) {
			uri="member/updateForm.jsp";
		}
		
		//2) Service & 결과 (저장 & Forward)
		MemberService service = new MemberService();
		MemberDTO dto = service.selectOne(id);
		request.setAttribute("mdto", dto);
				
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
