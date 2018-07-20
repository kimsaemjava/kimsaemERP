package erp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import erp.dto.LoginDTO;
import erp.service.ERPService;
import erp.service.ERPServiceImpl;
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		System.out.println(id);
		
		ERPService service = new ERPServiceImpl();
		LoginDTO result=service.login(id, pass);
		req.setAttribute("loginUser", result);
	
		if(check!=null){
			if(check.equals("T")&&result!=null){
				Cookie cookie =new Cookie("setid", result.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		String menupath = "";
		String viewpath = "";
//		System.out.println(result.getName());
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		if(result!=null){
			System.out.println("로그인성공");
			menupath = result.getMenupath();
			viewpath = "/emp/mypage.jsp";
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", result);			
		}else{
			menupath = "/emp/pub_menu.jsp";
			viewpath = "/emp/login.jsp";
		}
		req.setAttribute("menupath", menupath);
		req.setAttribute("viewpath", viewpath);
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}
}

