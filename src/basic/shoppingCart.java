package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart.do")
public class shoppingCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		String proDuctName = request.getParameter("item");
		
		HttpSession ses= request.getSession();
		Integer count=(Integer)ses.getAttribute(proDuctName);
		//item에 해당하는 attributee가 없으면 null을 리턴
		if(count==null){//최초 선택
			ses.setAttribute(proDuctName, 1);
		}else{
			//최초 작업이 아니므로 value에 1만 더해서 다시 저장
			ses.setAttribute(proDuctName, count+1);
		}
		
		RequestDispatcher rd=
				request.getRequestDispatcher("/servlettest/cart.jsp");
		rd.forward(request, response);
	}

}
