package fw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 하이퍼링크를 클리갷서 뷰를 나타낼때 호출될 서블릿
 * 서블릿내부에서 mainLayout.jsp로 forward되며
 * 샘플과 같은 구조에서는 left메뉴 부분에 연결될 view와 오른쪽 컨텐츠 부분에 연결될 view의 정보를 넘겨주는
 * 서블릿
 * 원래는 .properties파일 이나 xml과 같은 설정 파일에 view에 대한 정보를 명시하고 파싱해서 
 * 정보를 가져와야 하지만 클릭할때 파라미터로 뷰에 대한 정보를 넘긴다.
 * 왼쪽에 연결될 뷰에 대한 정보는 menupath라는 파라미터로 넘긴다.
 * 오른쪽에 연결될 뷰에 대한 정보는 viewpath라는 파라미터로 넘긴다.
 * */
@WebServlet(name = "view", urlPatterns = { "/view.html" })
public class ViewTemplateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menupath =request.getParameter("menupath");
		String viewpath = request.getParameter("viewpath");
		System.out.println(menupath+":"+viewpath);
		//템플릿 서블릿에서 응답할때는 무조건 mainLayout.jsp로 forward하고
		//forward하기 전에 템플릿 페이지에 연결할 view의 정보를 request에 공유해야 한다.
		
		request.setAttribute("menupath", menupath);
		request.setAttribute("viewpath", viewpath);
		RequestDispatcher rd=
				request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
		
	}

}
