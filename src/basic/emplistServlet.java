package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.empDTO;
import emp.service.empService;
import emp.service.empServiceImpl;

public class emplistServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		empService service = new empServiceImpl();
		
		ArrayList<empDTO> empList=service.search();
	
		req.setAttribute("mydata", empList);

		RequestDispatcher rd= req.getRequestDispatcher("/servlettest/list.jsp");
		rd.forward(req,res);
		
		
	}
}

