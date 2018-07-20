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
import erp.dto.empDTO;
import erp.service.ERPService;
import erp.service.ERPServiceImpl;
import erp.service.empService;
import erp.service.empServiceImpl;
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		System.out.println(id);
		
		ERPService service = new ERPServiceImpl();
		LoginDTO result=service.login(id, pass);
		req.setAttribute("loginUser", result);
		String view="";
		
		if(check!=null){
			if(check.equals("T")&&result!=null){
				Cookie cookie =new Cookie("setid", result.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		String menupath = "";
		String viewpath = "";
		System.out.println(result.getName());
		//�α��� �����ϸ� ������ �����ϰ� ���ǿ� �α��� ������ ������ �߰��Ѵ�.
		if(result!=null){
			view="/template/mainLayout.jsp";
			System.out.println("�α��μ���");
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", result);
			
			menupath = result.getMenupath();
			viewpath = "/emp/mypage.jsp";
		}else{
			view="/template/mainLayout.jsp";
			System.out.println("�α��ν���");
			menupath = "/menu/pub_menu.jsp";
			viewpath = "/emp/login.jsp";
		}
		req.setAttribute("menupath", menupath);
		req.setAttribute("viewpath", viewpath);
		RequestDispatcher rd= req.getRequestDispatcher(view);
		rd.forward(req,res);
	}
}
