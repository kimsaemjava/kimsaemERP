package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		// 1. 비즈니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> empList= service.getMemberList();
		
		// 2. 데이터 공유
		req.setAttribute("empList", empList);
		
		// 3. 요청재지정 - forward
		RequestDispatcher rd = req.getRequestDispatcher("/emp/list.jsp");
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}

