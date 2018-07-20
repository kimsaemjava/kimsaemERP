package erp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.LoginDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name = "list", urlPatterns = { "/list.do" })
public class EmpListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");	
		
		// 1. 비즈니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<LoginDTO> empList= service.getMemberList();
		
		// 2. 데이터 공유
		req.setAttribute("empList", empList);
		
		String menupath = "/menu/insa_menu.jsp";
		String viewpath = "/emp/emp_list.jsp";
		req.setAttribute("menupath", menupath);
		req.setAttribute("viewpath", viewpath);
		
		// 3. 요청재지정 - forward
		RequestDispatcher rd = req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req, res);
	}

}
