package controllerM;

import java.io.IOException;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;


@WebServlet("/mupdate")
public class C05_mUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C05_mUpdate() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} //doGet


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 요청분석
		//=> 한글처리,request 의 Parameter 처리 -> dto에 담기
		//=> 수정성공 -> 내정보표시 (memberDetail.jsp)
		//=> 수정실패 -> 재수정 유도 (updateForm.jsp)
		//=> 그러므로 출력을 위한 객체(mdto)가 필요함
		
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
		
		request.setAttribute("mdto", mdto);
		String uri="member/memberDetail.jsp";//성공
		
		//2) Service & 결과 (저장 & Forward)	
		MemberService sservice = new MemberService();
		
		if(sservice.update(mdto)>0) {
			//=> 성공
			request.setAttribute("message", "회원 정보 수정 완료");
		}else {
			//=> 실패
			request.setAttribute("message", "회원 정보 수정 실패");	
			uri="member/updateForm.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}//dopost
	
	
}
