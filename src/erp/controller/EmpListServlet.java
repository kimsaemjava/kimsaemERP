package erp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.LoginDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "list", urlPatterns = { "/list.do" })
public class EmpListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");

		// 비지니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<LoginDTO> userlist = service.getMemberList();

		// 데이터공유
		req.setAttribute("userlist", userlist);
		
		String menupath = "/menu/insa_menu.jsp";
		String viewpath = "/emp/emp_list.jsp";
	
		req.setAttribute("menupath",  menupath);
		req.setAttribute("viewpath", viewpath);
		
		// 요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/template/content.jsp");
		rd.forward(req, res);
	}
}
