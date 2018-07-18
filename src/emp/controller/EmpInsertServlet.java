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

public class EmpInsertServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		//System.out.println("서블릿 요청 성공");
		
		req.setCharacterEncoding("euc-kr");
	/*	res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();*/	//forward 후에 필요없음
		
		//1. 클라이언트의 요청정보 추출
		String deptno = req.getParameter("deptno");//부서번호
		String name = req.getParameter("name"); //성명
		String id = req.getParameter("id");//사번
		String pass = req.getParameter("pass"); //패스워드
		String addr = req.getParameter("addr");//주소
		int point = Integer.parseInt(req.getParameter("point")); //포인트
		String grade = req.getParameter("grade"); //등급
		
		//2. 비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		EmpDTO user = new EmpDTO(id, pass, name, addr, grade, point, deptno);
		int result = service.insert(user);
		
		//3. 데이터 공유
		String msg = "";
		if(result>=1){
			msg = result+"개 행 삽입 성공";
		}else{
			msg = "삽입실패";
		}
		req.setAttribute("msg", msg);
		
		//4. 요청재지정 - forward
		RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp"); 
		rd.forward(req, res);
		
		//res.sendRedirect("/serverweb/basic/insertResult.html");
	}
}
