package emp.controller;

import java.io.IOException;

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

@WebServlet(name = "login", urlPatterns = ("/login.do"))
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		//1.요청 정보 추출
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		//추가
		String check = req.getParameter("member_id_save");
		
		System.out.println("id :" + id);
		System.out.println("pass :" + pass);
		
		//2. 비즈니스 메소드호출
		EmpService service = new EmpServiceImpl();
		EmpDTO loginUser = service.login(id, pass);
		
		//로그인 성공하면 쿠키를 설정
		//-> 아이디 저장이 체크된 상태로 로그인 버튼이 눌려지고 로그인이 성공하면
		//아이디를 쿠키에 저장하기
		if(check!=null){
			if(check.equals("T") & loginUser != null){						//로그인 유저가 null 아니면
				Cookie cookie = new Cookie("id", loginUser.getEmp_id());	//DB에 한번 나갔다 온의미
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		//login.jsp에 작성있음

		//3. 데이터 공유
		req.setAttribute("loginUser", loginUser);
		
		
		
		//로그인 성공하면 세션을 생성하고 세션에 로그인 유저의 정보를 추가한다.
		//4. 요청재지정
		//추가(성공시, 실패시)
		String url="";
		if(loginUser!=null){	//로그인성공
			HttpSession ses = req.getSession();
					ses.setAttribute("loginUser", loginUser);
		}else{					//실패시
			url = "/emp/login.jsp";
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		
		rd.forward(req, res);
	}
}
