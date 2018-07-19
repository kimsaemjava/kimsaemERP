package emp.controller;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dto.empDTO;
import emp.service.empService;
import emp.service.empServiceImpl;
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		System.out.println(id);
		
		

		
		empService service = new empServiceImpl();
		empDTO result=service.login(id, pass);
		req.setAttribute("loginUser", result);
		String view="";
		
		if(check!=null){
			if(check.equals("T")&&result!=null){
				Cookie cookie =new Cookie("setid", result.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		if(result!=null){
			view="/template/mainLayout.jsp";
			System.out.println("로그인성공");
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", result);
			req.setAttribute("menupath", "/menu/insa_menu.jsp");
			req.setAttribute("viewpath", "/emp/mypage.jsp");

			
		}else{
//			pubmenu, login
			view="/template/mainLayout.jsp";
			System.out.println("로그인실패");
			req.setAttribute("menupath", "/menu/pub_menu.jsp");
			req.setAttribute("viewpath", "/emp/login.jsp");
		}
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher(view);
		rd.forward(req,res);
	}
}

