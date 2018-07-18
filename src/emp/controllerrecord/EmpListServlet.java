package emp.controllerrecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

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
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist= service.getMemberList();
		int size = userlist.size();
		//System.out.println("서블릿=>"+size);
		EmpDTO user = null;
	  /*for(int i = 0; i<userlist.size();i++){
			member = userlist.get(i);
			System.out.print(member.getId());
		}*/
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>회원목록보기</h1>");
		out.println("<hr/>");
		
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr bgColor='#ffff99'>");
		out.println("<th>아이디</th><th>비밀번호</th><th>이름</th>");
		out.println("<th>주소</th><th>입사일</th><th>등급</th>");
		out.println("<th>포인트</th><th>부서번호</th><th>삭제</th>");
		out.println("</tr>");
		
		out.println("<tbody>");
		for(int i=0; i<size;i++){
			user = userlist.get(i);
			out.println("<tr>");
			out.println("<td>"+user.getId()+"</td>");
			out.println("<td>"+user.getPass()+"</td>");
			out.println("<td>"+user.getName()+"</td>");
			out.println("<td>"+user.getAddr()+"</td>");
			out.println("<td>"+user.getHiredate()+"</td>");
			out.println("<td>"+user.getGrade()+"</td>");
			out.println("<td>"+user.getPoint()+"</td>");
			out.println("<td>"+user.getDeptno()+"</td>");
			out.println("<td><a href='/serverweb/emp/delete.do?info=test&id="+user.getId()+"'>삭제</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");
		
	}
}
