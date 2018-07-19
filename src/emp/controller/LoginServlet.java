package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name="login", urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LoginServlet 서블릿 성공");

		req.setCharacterEncoding("euc-kr");
		
		//1.요청정보 추출
		System.out.println("LoginServlet연습 - Login 연습중");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		System.out.println("id : "+id+" pass : "+pass);

		// 2. 비지니스 메소드 호출
		EmpDTO loginUser = new EmpDTO();
		EmpService service = new EmpServiceImpl();
		loginUser = service.login(id, pass);
		/*System.out.println(loginUser.getId());*/
		
		//로그인 성공하면 쿠키를 설정
		//-> 아이디 저장이 체크된 상태로 로그인 버튼이 눌려지고 로그인이 성공하면
		//아이디를 쿠키에 저장
		if(check != null){
			if(check.equals("T") & loginUser != null){
				Cookie cookie = new Cookie("id", loginUser.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		//4.
		String url="";	
		if(loginUser != null){//로그인 성공
			url = "/index.jsp";
			HttpSession ses = req.getSession();
			ses.setAttribute("loginUser", loginUser);
		}else{
			url = "/emp/login.jsp";//로그인 실패
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, res);
		
		
		
		/*RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, res);*/
		/*String msg = "";
		if (result >= 1) {
			msg = result + "개 형 삽입 성공";
		} else {
			msg = "삽입실패";
		}*/

		/*req.setAttribute("msg", msg);*/
		/*RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp");
		rd.forward(req, res);*/
	}
}