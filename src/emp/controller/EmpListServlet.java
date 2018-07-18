package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		//System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		
		//비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist= service.getMemberList();
		
		//데이터공유
		req.setAttribute("userlist", userlist);
		
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/emp/list.jsp"); 
		rd.forward(req, res);
	}
	
	//doPost source에서 오버라이딩해줌
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
