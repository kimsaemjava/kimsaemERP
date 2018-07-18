package emp.controller;

import java.io.IOException;
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

@WebServlet(name = "search", urlPatterns={"/emp/search.do"})
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("euc-kr");
		
		String column = request.getParameter("column");
		String search = request.getParameter("search");
		String pass = request.getParameter("pass");
		System.out.println("°Ë»ö¾î: "+search);
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist = service.search(column, search, pass);

		request.setAttribute("userlist", userlist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/emp/list.jsp"); 
		rd.forward(request, response);
		
	}
}
