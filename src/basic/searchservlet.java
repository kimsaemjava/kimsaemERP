package basic;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.empDTO;
import emp.service.empService;
import emp.service.empServiceImpl;
@WebServlet(name = "search", urlPatterns = { "/emp/search.do" })
public class searchservlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		empService service = new empServiceImpl();
		String col =req.getParameter("column");
		String value = req.getParameter("search");
		String pass = req.getParameter("pass");
		System.out.println("col = "+col);
		System.out.println("value = "+value);
		ArrayList<empDTO> empList=service.getemplist(col, value,pass);
	
		req.setAttribute("mydata", empList);
		
		RequestDispatcher rd= req.getRequestDispatcher("/servlettest/list.jsp");
		rd.forward(req,res);
		
	}
}

