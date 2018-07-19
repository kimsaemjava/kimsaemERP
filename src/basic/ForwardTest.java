package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.empDTO;

@WebServlet(name = "forward", urlPatterns = { "/forward.do" })
public class ForwardTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		System.out.println("Forward연습 - Redirect 서블릿 실행중");
		out.println("<h1>요청 재지정 연습 - Forward</h1>");
		//1. 데이터 공유 - db에서 가져온 결과나 비지니스로직 수행 결과
		empDTO dto =new empDTO("111", "", "jang", "", "", 100, "11");
		//요청 범위안에서 "mydata"라는 이름으로 dto가 공유될 수 있도록 공유 작업
		request.setAttribute("mydata", dto);
		
		request.setAttribute("menupath", "/menu/pub_menu.jsp");
		request.setAttribute("viewpath", "/emp/login.jsp");
		
		//3. 요청재지정 - forward
		RequestDispatcher rd =
			request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
		
		out.println("<h1>요청재지정 연습-forward_end</h1>");
	}

}
