package basic;

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
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		
		System.out.println(id);
		System.out.println(pass);
		
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
			view="index.jsp";
			HttpSession ses= req.getSession();
			ses.setAttribute("loginuser", result);
		}else{
			view="/emp/login.jsp";
		}
		//res.sendRedirect(view);
		RequestDispatcher rd= req.getRequestDispatcher(view);
		rd.forward(req,res);
	}
}

