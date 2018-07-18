package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class logoutServler extends HttpServlet {

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//사용중인 세션을 받아오기 - false를 매개변수로 지정하면 기존에 사용하던 세션이 있으면 
		//세션객체를 리턴하고 없으면 null을 리턴한다.
		HttpSession ses= request.getSession(false);
		if(ses!=null){
			//세션을 제거한다.
			ses.invalidate();
		}
		response.sendRedirect("/kimsaemERP/index.jsp");
	}

}
