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

public class EmpListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
						HttpServletResponse res) throws ServletException, IOException{
		System.out.println("테스트");
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html; charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		
		//비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist = service.getMemberList();
		int size = userlist.size();
		
		
		//데이터 공유
		req.setAttribute("userlist", userlist);
		
		//요청 재지정
		RequestDispatcher rd = 
				req.getRequestDispatcher("/emp/list.jsp");
		//
		rd.forward(req, res);
		
		
		
		
		/*System.out.println("서블릿 =-> "+ size);
		
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h1>사원목록</h1>");
		out.println("<hr/>");
		
		out.println("<table border = '1'>");
		out.println("<tr bgColor='skyblue'>");
		
		out.println("<th>아이디</th><th>성명</th><th>패스워드</th>");
		out.println("<th>주소</th><th>입사년월</th><th>등급</th>");
		out.println("<th>포인트</th><th>부서번호</th><th>삭제</th>");
		out.println("</tr>");
		
		for (int i = 0; i < size; i++) {
			EmpDTO user = userlist.get(i);
			out.println("<tr>");
			out.println("<td>"+user.getEmp_id()+"</td>");
			out.println("<td>"+user.getName()+"</td>");
			out.println("<td>"+user.getPass()+"</td>");
			out.println("<td>"+user.getAddr()+"</td>");
			out.println("<td>"+user.getHiredate()+"</td>");
			out.println("<td>"+user.getGrade()+"</td>");
			out.println("<td>"+user.getPoint()+"</td>");
			out.println("<td>"+user.getDeptNo()+"</td>");
			out.println("<td><a href = '/serverweb/emp/"
					+ "delete.do?info=test&id="+user.getEmp_id()+"'>삭제</a></td>");
			//?로구분하고 띄어쓰기 없어야 한다.'도 위치 확인
			out.println("</tr>");
			//404 에러에서 /붙으면 찾기 힘듬
			//대부분 서버에 오류가 있음

		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");*/
		
	}
}
