package emp.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		//1. 요청정보 추출
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("member_id_save");
		
		//2. 비지니스메소드호출
		EmpService service = new EmpServiceImpl();
		EmpDTO loginUser = service.login(id, pass);
		
		//로그인 성공하면 쿠키를 설정
		//-> 아이디 저장이 체크된 상태로 로그인 버튼이 눌려지고 로그인이 성공하면 아이디를 쿠키에 저장하기
		if(check!=null){
			if(check.equals("T") & loginUser!=null){
				Cookie cookie = new Cookie("id", loginUser.getId());
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
			}
		}
		
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		//4. 요청재지정
		String url = "";
		if(loginUser!=null){
			url="/index.jsp";	//로그인 성공
			HttpSession ses = request.getSession();
			ses.setAttribute("loginUser", loginUser);

		}else{
			url="/emp/login.jsp";	//로그인 실패
		}

		RequestDispatcher rd = request.getRequestDispatcher(url); 
		rd.forward(request, response);
	}
}
