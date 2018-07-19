package fw;
/*
 * 하이퍼링크를 클릭해서 뷰를 나타낼 때 호출될 서블릿
 * 서블릿 내부에서 mainLayout.jsp로 forward되며
 * 샘플과 같은 구조에서는 left메뉴 부분에 연결될 view와 오른쪽 컨텐츠 부분에 
 * 연결될 view의 정보를 넘겨주는 서블릿
 * 원래는 .properties파일이나 xml과 같은 설정 파일에 view에 대한 정보를 명시하고 파싱해서 
 * 정보를 가져와야하지만 클릭할 때 파라미터로 뷰에 대한 정보를 넘긴다.
 * 왼쪽에 연결될 뷰에 대한 정보는 menupath라는 파라미터로 넘긴다.
 * 오른쪽에 연결될 뷰에 대한 정보는 viewpath라는 파라미터로 넘긴다.
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "view", urlPatterns = { "/view.html" })
public class ViewTemplateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menupath = request.getParameter("menupath");
		String viewpath = request.getParameter("viewpath");
		
		request.setAttribute("menupath", menupath);
		request.setAttribute("viewpath", viewpath);
		RequestDispatcher rd = request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}
}
