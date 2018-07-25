package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dao.empDAO;
import erp.service.empService;
import erp.service.empServiceImpl;

@WebServlet(name = "IdCheck", urlPatterns = { "/IdCheck.do" })
public class IdCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String msg="";
		empService service = new empServiceImpl();
		boolean check = service.idCheck(id);
		if(check){
			msg="사용불가능아이디";
		}else{
			msg="사용가능아이디";
		}
		pw.println(msg);
	
	}

}
