package controllerF;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//** 요청을 처리하는 모든 컨트롤러들의 일관성 있는 처리를 위해 필요
//=> 그러므로 요청을 처리하는 모든 컨트롤러들은 반드시 구현 해야함


public interface Ex04_Controller {

	public String doUesr(HttpServletRequest request, HttpServletResponse response);



}
