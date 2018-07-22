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

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insert.do")
public class insertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		deptService service = new deptServiceImpl();
		String name = req.getParameter("name"); 
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String ssn = req.getParameter("ssn");
		String deptno= req.getParameter("deptno");
		String birth = req.getParameter("birthday");
		String value = req.getParameter("marry");
		int marry;
		if(value.equals("on")){
			marry=1;
		}else{
			marry=0;
		}
		String zipcode = req.getParameter("zipcode");
		String addr = req.getParameter("addr");
		String detailaddr = req.getParameter("detailaddr");
		String phonehome = req.getParameter("phonehome");
		String phoneco = req.getParameter("phoneco");
		String phonecell = req.getParameter("phonecell");
		String email = req.getParameter("email");
		int result=service.insert(id, pass, name, ssn, birth, marry, deptno, 
				zipcode, addr, detailaddr, 
				phonehome, phoneco, phonecell, email);
		
		res.sendRedirect("/kimsaemERP/emplist.do");
//		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
//		rd.forward(req,res);
	}

}
