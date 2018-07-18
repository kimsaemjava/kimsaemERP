package emp.controllerrecord;

import java.io.IOException;
import java.io.PrintWriter;

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
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
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
	/*	user.setDeptno(deptno);
		user.setName(name);
		user.setId(id);
		user.setPass(pass);
		user.setAddr(addr);
		user.setPoint(point);
		user.setGrade(grade);*/
		int result = service.insert(user);
		
		
		//3. 응답화면을 생성
		String msg = "";
		if(result>=1){
			msg = result+"개 행 삽입 성공";
		}else{
			msg = "삽입실패";
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>"+msg+"</h1>");
		out.println("<a href='/serverweb/emp/list.do'>회원목록보기</a>");
		/*if(result==0){	
			out.println("<h1>삽입실패</h1>");
			out.println("<h2>삽입실패</h2>");
		}else{
			out.println("<h1>삽입성공</h1>");
			out.println("<h2>1개의 행 삽입 성공</h2>");
		}*/
		out.println("</body>");
		out.println("</html>");
	
	}
}
