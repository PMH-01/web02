package controllerM;

import java.io.IOException;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;


@WebServlet("/mdelete")
public class C06_mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C06_mDelete() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//1) 요청분석
    	//=> id 필요(session에 보관된 id 사용: loginID)
    	//=> 성공/실패: home.jsp
    	String id=(String)request.getSession().getAttribute("loginID");
    	String uri="home.jsp";
    	
    	
    	//2) Service & 결과
    	//=> 삭제
    	//=> 성공: session 무효화
    	MemberService sservice = new MemberService();
    	//=> 탈퇴 실패 Test
    	id="brown";
    	
    	if(sservice.delete(id)>0){
    		//=> 성공 : session 무효화 -> home.jsp
    		System.out.println("** 탈퇴 성공 **");
    		request.getSession().invalidate();
    		request.setAttribute("message", id+"님 탈퇴 성공, 1개월 후 재가입 가능");
    		
    	}else {
    		//=> 실패
    		System.out.println("** 탈퇴 실패 **");
    		request.setAttribute("message", id+"님 탈퇴 실패, 관리자에게 문의 해주세요");
    	} 
    	//=> home 표시할때 Forward/Redirect 비교
    	//response.sendRedirect(uri);
    	request.getRequestDispatcher(uri).forward(request, response);
    	
	} //doGet


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}//dopost
}
