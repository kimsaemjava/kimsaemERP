package erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.EmpDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "emp/read", urlPatterns={"/emp/read.do"})
public class EmpReadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("서블릿 요청 성공");
		request.setCharacterEncoding("euc-kr");
		
		//1. 요청정보 추출
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String view = "";
		if(action.equals("UPDATE")){
			view = "/emp/emp_update.jsp";
		}else if(action.equals("READ")){
			view = "/emp/emp_read.jsp";
		}
		
		//2. 비지니스메소드 호출
		EmpService service = new EmpServiceImpl();
		EmpDTO user = service.read(id);

		//3. 데이터 공유
		request.setAttribute("user", user);
		
		//4. 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher(view); 
		rd.forward(request, response);
		
		
	}
}
