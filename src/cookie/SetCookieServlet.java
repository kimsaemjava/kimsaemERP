package cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//쿠키 설정하기
@WebServlet(name = "setCookie", urlPatterns = { "/setCookie" })
public class SetCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("SetCookies");
		
		//쿠키에 저장하고 싶은 데이터를 셋팅해서 Cookie객체를 생성
		Cookie c1 = new Cookie("bookTitle", URLEncoder.encode("운수좋은날", "euc-kr"));
		Cookie c2 = new Cookie("bookPage", "128");
		
		//쿠키에 대한 유효시간을 설정 - 초단위
		c1.setMaxAge(60*60*24);
		c2.setMaxAge(60*60*24);
		
		//responser에 쿠키를 저장
		response.addCookie(c1);
		response.addCookie(c2);
		
	}

}
