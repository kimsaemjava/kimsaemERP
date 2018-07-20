package erp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.loginDTO;
import erp.service.loginService;
import erp.service.loginServiceImpl;

/**
 * Servlet implementation class readServlet
 */
@WebServlet("/empread.do")
public class readServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		loginService service = new loginServiceImpl();
		String name =req.getParameter("id");
		ArrayList<loginDTO> result=service.empinfo(name);
		System.out.println(result);
		//부서별목록 출력
		req.setAttribute("empread", result);
		req.setAttribute("menupath", "/menu/insa_menu.jsp");
		req.setAttribute("viewpath", "/emp/emp_read.jsp");
		
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}

}
