package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServlet extends HttpServlet {
	//클라이언트가 양식태그에 입력한 데이터를 추출
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			System.out.println("ParamTestServlet 실행");
			//요청 정보에 한글 세팅
			req.setCharacterEncoding("euc-kr");
			//응답 정보에 대한 타입과 문자셋을 설정
			res.setContentType("text/html;charset=euc-kr");
			//클라이언트가 입력한 요청 정보를 추출하기
			String id= req.getParameter("id");
			String pass= req.getParameter("pass");
			System.out.println("id : " +id);
			System.out.println("password : " +pass);
			//응답정보를 클라이언트에 출력하기위해서 스트림객체를 추출
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>아이디:"+id+"</h1>");
			out.println("<h1>패스워드:"+pass+"</h1>");
			out.println("</body>");
			out.println("</html>");
		}
}
