package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import erp.dto.LoginDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name = "idcheck", urlPatterns = { "/emp/idcheck.do" })
public class IdCheckServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		String id = req.getParameter("id");
	
		EmpService service = new EmpServiceImpl();
		boolean state = service.idCheck(id);
		String msg = "";
	
		if(state){
			msg = "사용불가능아이디";
		}else{
			msg = "사용가능아이디";
		}
		res.setContentType("text/html;charset=euc-kr");
		res.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = res.getWriter();
		pw.println(msg);
	}
}













