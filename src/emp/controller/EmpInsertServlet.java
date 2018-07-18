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
	public void service(HttpServletRequest req,
						HttpServletResponse res) throws ServletException, IOException{
		System.out.println("테스트");
		
		req.setCharacterEncoding("euc-kr");
		/*res.setContentType("text/html; charset=euc-kr");
		PrintWriter out = res.getWriter();*/
		
		String deptno = req.getParameter("deptno");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String addr = req.getParameter("addr");
		String point = req.getParameter("point");
		String grade = req.getParameter("grade");
		
		
		//1. 클라이언트의 요청정보 추출
		System.out.println("deptno :" + deptno);
		System.out.println("name :" + name);
		System.out.println("id :" + id);
		System.out.println("pass :" + pass);
		System.out.println("addr :" + addr);
		System.out.println("pint :" + point);
		System.out.println("grade :" + grade);
		
		//2. 비지니스 메소드 호출
		EmpDTO user = new EmpDTO(id, pass, name ,addr, grade, Integer.parseInt(point), deptno);
		
		EmpService service = new EmpServiceImpl();
		int result = service.insert(user);
		
		//3. 응답화면 생성
		//데이터 공유
		
		String msg = "";
		if(result >=1 ){
			msg = result+"개 행 삽입 성공";
		}else{
			msg = "삽입실패";
		}
		
		//요청 재지정 - sendRedirect
		//
	/*	res.sendRedirect("/serverweb/basic/insertResult.html");*/
		
		//
		req.setAttribute("msg", msg);
		
		//
		RequestDispatcher rd = 
				req.getRequestDispatcher("/emp/InsertResult.jsp");
		rd.forward(req, res);
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + msg +"</h1>");
		out.println("<h3 href='/serverweb/emp/list.do'>회원목록보기</h3>");
		out.println("</body>");
		out.println("</html>");*/
		
	}
}
