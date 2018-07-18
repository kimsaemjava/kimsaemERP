package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;
@WebServlet(name = "emp/search", urlPatterns = { "/emp/search.do" })
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		String pass = req.getParameter("pass");
		System.out.println("검색어:"+search);
		//비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist =
					service.search(column, search,pass);
	
		//데이터공유
		req.setAttribute("userlist", userlist);
		
		//요청재지정
		RequestDispatcher rd = 
				req.getRequestDispatcher("/emp/list.jsp");
		rd.forward(req, res);
	}
}













