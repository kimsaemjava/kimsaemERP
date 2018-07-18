package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;
@WebServlet(name = "emp/update", urlPatterns = ("/emp/update.do"))
public class EmpUpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
						HttpServletResponse res)throws ServletException, IOException{
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//1. 요청정보 추출
		String id = req.getParameter("id");
		String addr = req.getParameter("addr");
		String grade = req.getParameter("grade");
		String point = req.getParameter("point");
		
		System.out.println("EmpUpdateServlet : "+id);
		
		
		//2. 비즈니스 메소드호출
		EmpService service = new EmpServiceImpl();
		EmpDTO data = new EmpDTO(id , addr, grade, Integer.parseInt(point));
		int result = service.update(data);
		System.out.println(result);
		
		//3.요청 재지정
		if(result <= 0){
			res.sendRedirect("/serverweb/emp/update.do");
		}else{
			res.sendRedirect("/serverweb/emp/list.do");
		}
	}
}
