package erp.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "insert", urlPatterns = { "/insert.do" })
public class EmpInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");

		// 1. 클라이언트의 요청정보 추출
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String ssn = req.getParameter("ssn");
		String marry = req.getParameter("marry");
		String gender = req.getParameter("gender");
		String deptno = req.getParameter("deptno");
		String zipcode = req.getParameter("zipcode");
		String addr = req.getParameter("addr");
		String detailaddr = req.getParameter("detailaddr");
		String phonehome = req.getParameter("phonehome");
		String phoneco = req.getParameter("phoneco");
		String phonecell = req.getParameter("phonecell");
		String email = req.getParameter("email");

		// marry에 대한 처리
		if (marry == null) { // 체크박스를 선택하지 않은 미혼이라는 의미
			marry = "0";
		}
		// 날짜 데이터를 Date로 처리하는 경우
		// - 입력형식은 날짜 데이터에 맞게 입력받을 수 있도록 view에서 정의

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		long mydate = 0;
		try {
			mydate = sdf.parse(birthday).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 2. 비즈니스 메소드 호출
		MemberDTO emp = new MemberDTO(id, pass, name, ssn, new Date(mydate), marry, deptno, 
				zipcode, addr, detailaddr,phonehome, phoneco, phonecell, email);
		
		System.out.println("서블릿→ "+emp);
		EmpService service = new EmpServiceImpl();
		int result = service.insert(emp);

		res.sendRedirect("/kimsaemERP/emp/list.do");
	}
}
