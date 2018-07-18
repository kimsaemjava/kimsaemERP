package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException {
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String[] lang = req.getParameterValues("language");
		String save = req.getParameter("save");
		
		PrintWriter out = res.getWriter();
		
		out.println("<head>");
		out.println("<body>");
		out.println("<center><h1>client form data 처리</h1><center>");
		//이름
		out.println("<p>이름 : ");
		if (name == "") {
			out.println("<이름을 입력하세요></p>");
		} else {
			out.println(name + "</p>");
		}
		//주소
		out.println("<p>주소 : ");
		if (addr == "") {
			out.println("<주소를 입력하세요></p>");
		} else {
			out.println(addr + "</p>");
		}
		//언어
		out.println("<p>사용가능한 Language 선택.<br/>");
		if (lang == null) {
			out.println("<p>사용가능한 language 가 없습니다.</p>");
		} else {
			for (int i = 0; i < lang.length; i++) {
				out.println(lang[i] + "<br/>");
			}
			out.println("</p>");
		}
		//저장 유무
		if (save == null) {
			out.println("<p>입력 정보 저장 유무를 선택해 주십시오.</p>");
		} else {
			out.println("<p>입력 정보 저장 유무 :" + save + "</p>");
		}
		out.println("</body>");
		out.println("</head>");

	}
}
