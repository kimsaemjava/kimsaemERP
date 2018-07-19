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
		
		request.setAttribute("menupath", "/menu/pub_menu.jsp");
		request.setAttribute("viewpath", "/emp/login.jsp");
		
		//3. 요청재지정 - forward
		RequestDispatcher rd =
			request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
		
	}

}
