package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "idcheck", urlPatterns = { "/emp/idcheck.do" })
public class IdCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cahce-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");
		String msg = "";
		
		EmpService service = new EmpServiceImpl();
		boolean state = service.idCheck(id);
		
		if (state) {
			msg = "사용 불가능 아이디";
		} else {
			msg = "사용 가능 아이디";
		}
		//System.out.println("post방식으로 ajax요청: "+msg);
		pw.println(msg);
		
	}
}
