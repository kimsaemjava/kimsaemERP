package fw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "View", urlPatterns = { "/View.html" })
public class ViewTemplateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//jsp.menu에서 보내는걸 받아라
		String menupath = request.getParameter("menupath");
		String viewpath = request.getParameter("viewpath");
		System.out.println(menupath + " : " + viewpath);
		
		//템플릿 서블릿에서 응답할때는 무조건 mainLayout.jsp로 forward
		//포워드 하기전 템플릿 페이지에 연결할 view의 정보를 request에 공유
		request.setAttribute("menupath", menupath);
		request.setAttribute("viewpath", viewpath);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}
}
