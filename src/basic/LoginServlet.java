package basic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dto.loginDTO;
import login.service.loginService;
import login.service.loginServiceImpl;
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		
		System.out.println(id);
		System.out.println(pass);
		
		loginService service = new loginServiceImpl();
		loginDTO result=service.login(id, pass);
		System.out.println("로그인 서블릿 포토 :"+result.getProfile_photo());
		req.setAttribute("loginUser", result);
		
		if(check!=null){
			if(check.equals("T")&&result!=null){
				Cookie cookie =new Cookie("setid", result.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
	
		
		
		if(result!=null){
			req.setAttribute("menupath", result.getDetailaddr());
			req.setAttribute("viewpath", "/emp/mypage.jsp");
			HttpSession ses= req.getSession();
			ses.setAttribute("loginuser", result);
		}else{
			req.setAttribute("menupath", "/menu/pub_menu.jsp");
			req.setAttribute("viewpath", "/emp/login.jsp");
		}
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}
}

