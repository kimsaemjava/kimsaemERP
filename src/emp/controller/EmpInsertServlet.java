package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
/*		// 처리를 위한 기본 작업
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();*/
		
		// 1. 클라이언트의 요청정보 추출
		String deptno= req.getParameter("deptno");
		String name= req.getParameter("name");
		String id= req.getParameter("id");
		String pass= req.getParameter("pass");
		String addr= req.getParameter("addr");
		int point = Integer.parseInt(req.getParameter("point"));
		String grade= req.getParameter("grade");

		// 2. 비즈니스 메소드 호출
		EmpDTO emp = new EmpDTO(id,pass,name,addr,grade,point,deptno);
		EmpService service = new EmpServiceImpl();
		int result = service.insert(emp);
		
		// 3. 데이터 공유
		String msg ="";
		if(result>=1){
			msg = result +"개 행 삽입 성공";
		}else{
			msg = "삽입 실패";
		}
		req.setAttribute("msg", msg);
		
		// 4. 요청재지정 - forward
		RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp");
		rd.forward(req, res);
		
		// 3. 요청재지정 - sendRedirect	
		//res.sendRedirect("/serverweb/basic/insertResult.html");
	}
}
