package controllerM;

import java.io.IOException;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;


@WebServlet("/mjoin")
public class C04_mJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C04_mJoin() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} //doGet


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청분석
		//=> 한글처리,request 의 Parameter 처리 -> dto에 담기
		//=> 가입성공 -> 로그인 화면 이동 (loginForm.jsp)
		//=> 가입실패 -> 재가입 유도 (joinForm.jsp)
		
		MemberDTO mdto = new MemberDTO();
		mdto.setId(request.getParameter("id"));
		mdto.setPassword(request.getParameter("password"));
		mdto.setName(request.getParameter("name"));
		mdto.setAge(Integer.parseInt(request.getParameter("age")));
		mdto.setJno(Integer.parseInt(request.getParameter("jno")));
		mdto.setInfo(request.getParameter("info"));
		mdto.setPoint(Double.parseDouble(request.getParameter("point")));
		mdto.setBirthday(request.getParameter("birthday"));
		mdto.setRid(request.getParameter("rid"));
		
		String uri="member/loginForm.jsp";
		
		
		//2) Service & 결과 (저장 & Forward)	
		MemberService sservice = new MemberService();
		//int cnt = sservice.insert(mdto);
		
		if(sservice.insert(mdto)>0) {
			//=> 성공
			request.setAttribute("message", "회원가입 성공 로그인 후 이용해주세요");
		}else {
			//=> 실패
			request.setAttribute("message", "회원가입 실패");	
			uri="member/joinForm.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}//dopost
	
	
}
