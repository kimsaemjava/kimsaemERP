package erp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name = "emp/read", urlPatterns = { "/emp/read.do" })
public class EmpReadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		//1. 요청정보 추출
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		String viewpath="";
		String menupath="";
		if(action.equals("UPDATE")){
			viewpath = "/emp/emp_update.jsp";
		}else if(action.equals("READ")){
			viewpath = "/emp/emp_read.jsp";
		}
		
		//2. 비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		MemberDTO user = service.read(id);
	
		//3. 데이터공유
		req.setAttribute("user", user);
		req.setAttribute("menupath", "/menu/insa_menu.jsp");
		req.setAttribute("viewpath", viewpath);
		
		//4. 요청재지정
		RequestDispatcher rd = 
				req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req, res);
	}
}













