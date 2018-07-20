package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.EmpDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "emp/read", urlPatterns = { "/emp/read.do" })
public class EmpReadServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");

		// 1. 요청정보 추출
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		String view="";
		
		if(action.equals("UPDATE")){
			view = "/emp/emp_update.jsp";
		}else if(action.equals("READ")){
			view = "/emp/emp_read.jsp";
		}
		
		// 2. 비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		EmpDTO user = service.read(id);

		// 3. 데이터공유
		req.setAttribute("user", user);
		System.out.println(user);
		
		// 4. 요청재지정
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);
	}
}