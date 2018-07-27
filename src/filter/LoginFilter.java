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

import erp.dto.MemberDTO;
// ... /emp/*로 요청되는 모든  서비스는 로그인을 하지 않았을 경우 로그인페이지로 forward하도록 작업
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpSession ses = httpReq.getSession(false);
		
		MemberDTO loginUser = null;
		//session에서 loginUser를 추출해서 MemberDTO가 null이면 로그인페이지로 forward
		//null이 아니면 다음 filter나 서블릿으로 요청을 넘긴다.
		String menupath = "";
		String viewpath = "";
		if(ses!=null){
			loginUser = (MemberDTO)ses.getAttribute("loginUser");
			if(loginUser==null){//로그인 상태가 아님
				menupath = "/menu/pub_menu.jsp";
				viewpath = "/emp/login.jsp";
				httpReq.setAttribute("menupath", menupath);
				httpReq.setAttribute("viewpath", viewpath);
				RequestDispatcher rd = 
			httpReq.getRequestDispatcher("/template/mainLayout.jsp");
				rd.forward(req, res);
			}else{
				chain.doFilter(req, res);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
