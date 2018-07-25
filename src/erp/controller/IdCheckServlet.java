package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name = "idcheck", urlPatterns = { "/emp/idcheck.do" })
public class IdCheckServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		System.out.println(id);
		EmpService service = new EmpServiceImpl();
		boolean idChk = service.idCheck(id);
		String msg = "";
		if(idChk){
			msg = "사용불가능 아이디";
		}else{
			msg = "사용가능 아이디";
		}
		pw.println(msg);
	}
}
