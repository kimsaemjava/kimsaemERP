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
@WebServlet(name = "emp/update", urlPatterns = { "/emp/update.do" })
public class EmpUpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
	
		
		//1. 클라이언트의 요청정보 추출
		String id = req.getParameter("id");
		String addr = req.getParameter("addr");
		String point = req.getParameter("point");
		String grade = req.getParameter("grade");
		
		//2. 비지니스 메소드 호출
		EmpDTO user =
				new EmpDTO(id, addr, grade,Integer.parseInt(point));
		System.out.println(user);
		
		EmpService service = new EmpServiceImpl();
		int result = service.update(user);
		
		//4. 요청재지정 - forward
		String view = "";
		if(result>=1){
			view = "/serverweb/emp/list.do";
		}else{
			view = "/serverweb/emp/read.do?id="+id+"&action=UPDATE";
		}
		res.sendRedirect(view);
		
	}
}













