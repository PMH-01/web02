package controllerM;

import java.io.IOException;
import java.util.List;

import domain.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;

@WebServlet("/mlist")
public class C01_mList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C01_mList() {
        super();
    }

    //** MVC2 Student List 출력
    //=> 요청분석 -> Service -> 결과저장(View 사용할수있도록), View(JSP)로 Forward
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청분석
		MemberService sservice = new MemberService();

		//2. Service
		List<MemberDTO> mlist = sservice.selectList();
		request.setAttribute("mlist", mlist);
		//request.setAttribute("banana", sservice.selectList());

		//3. 결과저장 & View(JSP)로 Forward
		String uri="member/memberList.jsp";
		request.getRequestDispatcher(uri).forward(request, response);


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
