package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.EmpDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "emp/update", urlPatterns = { "/emp/update.do" })
public class EmpUpdateServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");
		
		// 1. Client 요청정보 추출
		String id = req.getParameter("id");
		String addr = req.getParameter("addr");
		String point = req.getParameter("point");
		String grade = req.getParameter("grade");
		
		// 2. 비지니스 메소드 호출
		EmpDTO user = new EmpDTO(id, addr, grade, Integer.parseInt(point));
		EmpService service = new EmpServiceImpl();
		int result = service.update(user);
		
		// 3. 요청재지정 - forward
		String view = "";
		if(result>=1){
			view = "/serverweb/emp/list.do";
		}else{
			view = "/serverweb/emp/read.do?id="+id+"&action=UPDATE";
		}

		res.sendRedirect(view);
		
		// RequestDispatcher rd = req.getRequestDispatcher("/emp/emp_read.jsp");
		// rd.forward(req, res);
	}
}