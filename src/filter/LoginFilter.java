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

// /emp/*�� ��û�ϴ� ��� ���񽺴� �α����� ���� �ʾ��� ��� �α��� �������� forward�ϵ��� �۾�
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
		// session���� loginUser�� ����� MemberDTO�� ������ null�̸� login�������� forward
		// null�� �ƴϸ� doFilter�� ���� ����� Filter�� �������� ��û�� �ѱ��.
		String menupath = "";
		String viewpath = "";
		if (session != null) {
			loginUser = (MemberDTO) session.getAttribute("loginUser");
			if (loginUser == null) { // �α��� ���°� �ƴ�
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
