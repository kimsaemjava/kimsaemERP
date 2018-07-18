package cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//쿠키 설정하기
@WebServlet(name = "getCookie", urlPatterns = { "/getCookie" })
public class GetCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("GetCookies");
		//request객체에서 쿠키를 꺼낸다.
		Cookie[] cookies =request.getCookies();
		
		//쿠키에 저장된 value를 보관할 변수
		String bookTitle="";
		String bookPage="";
		
		//쿠키에 저장된 value 꺼내기
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("bookTitle")){
				bookTitle=URLDecoder.decode(cookies[i].getValue(), "euc-kr");
			}else if(cookies[i].getName().equals("bookPage")){
				bookPage=cookies[i].getValue();
			}
		}
		//꺼낸 쿠키를 공유
		request.setAttribute("bookTitle", bookTitle);
		request.setAttribute("bookPage", bookPage);
		
		//요청재지정
		//response.sendRedirect("/serverweb/servlettest/cookieResult.jsp");
		RequestDispatcher rd= request.getRequestDispatcher("/servlettest/cookieResult.jsp");
		rd.forward(request, response);
		
	}

}
