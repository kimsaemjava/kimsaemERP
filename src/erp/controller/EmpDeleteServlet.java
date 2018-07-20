package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.service.EmpService;
import erp.service.EmpServiceImpl;

public class EmpDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 처리를 위한 기본 작업
		//req.setCharacterEncoding("euc-kr");
		//res.setContentType("text/html;charset=euc-kr");
		//PrintWriter out = res.getWriter();

		// 1. 클라이언트의 요청정보 추출
		String id = req.getParameter("id");

		// 2. 비즈니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		int result = service.delete(id);

		// 3. 응답할 화면 생성
		String msg = "";
		if (result >= 1) {
			msg = result + "개 행 삭제 성공";
		} else {
			msg = "삭제 실패";
		}

		res.sendRedirect("/serverweb/emp/list.do");
	}
}
