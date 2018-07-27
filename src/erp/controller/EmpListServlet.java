package erp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name="emp/list" , urlPatterns={"/emp/list.do"})
public class EmpListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");
		//비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<MemberDTO> userlist = service.getMemberList();
		
		System.out.println("서블릿"+userlist);
		//데이터공유
		req.setAttribute("userlist", userlist);
		req.setAttribute("menupath", "/menu/insa_menu.jsp");
		req.setAttribute("viewpath", "/emp/emp_list.jsp");
		//요청재지정
		RequestDispatcher rd = 
			req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req, res);
	}
}













