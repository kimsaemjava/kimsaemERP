/*package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.EmpDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

public class EmpDeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		System.out.println("서블릿요청성공");
	
		//1. 요청정보 추출
		String id = req.getParameter("id");
		
		//2. 비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		int result = service.delete(id);
	
		//3. 응답화면생성
		String msg = "";
		if(result<0){
			msg = "삭제실패";
		}else{
			msg = result+"개 행 삭제 성공!!";
		}
		
		res.sendRedirect("/serverweb/emp/list.do");
	}
}













*/