package dept.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.deptDTO;
import dept.service.deptService;
import dept.service.deptServiceImpl;

@WebServlet("/register.do")
public class registerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		deptService service = new deptServiceImpl();
		ArrayList<deptDTO> result=service.deptlist();
		//부서목록 출력
		req.setAttribute("deptlist", result);
		req.setAttribute("menupath", "/menu/insa_menu.jsp");
		req.setAttribute("viewpath", "/emp/register.jsp");
		
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}

}
