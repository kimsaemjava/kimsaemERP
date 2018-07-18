package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		//技记按眉甫 积己
		HttpSession ses= request.getSession();
		//技记俊 单捞磐 傍蜡
		ses.setAttribute("mydata", id);
		
		RequestDispatcher rd=
				request.getRequestDispatcher("/servlettest/ses_first.jsp");
		rd.forward(request, response);
	}

}
