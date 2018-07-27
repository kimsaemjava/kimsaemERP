package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import erp.dto.LoginDTO;
import erp.dto.MemberDTO;

// /emp/*로 요청하는 모든 서비스는 로그인을 하지 않았을 경우 로그인 페이지로 forward하도록 작업
public class LoginFilter implements Filter {
	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpSession session = httpRequest.getSession();

		MemberDTO loginUser = null;
		// session에서 loginUser로 저장된 MemberDTO를 꺼내서 null이면 login페이지로 forward
		// null이 아니면 doFilter로 다음 연결된 Filter나 서블릿으로 요청을 넘긴다.
		String menupath = "";
		String viewpath = "";
		if (session != null) {
			loginUser = (MemberDTO) session.getAttribute("loginUser");
			if (loginUser == null) { // 로그인 상태가 아님
				menupath = "/menu/pub_menu.jsp";
				viewpath = "/emp/login.jsp";
				httpRequest.setAttribute("menupath", menupath);
				httpRequest.setAttribute("viewpath", viewpath);
				RequestDispatcher rd = httpRequest.getRequestDispatcher("/template/mainLayout.jsp");
				rd.forward(req, res);
			} else {
				chain.doFilter(req, res);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
