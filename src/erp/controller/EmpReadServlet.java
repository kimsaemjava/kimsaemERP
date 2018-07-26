package erp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.service.DeptService;
import erp.service.DeptServiceImpl;
import erp.service.empService;
import erp.service.empServiceImpl;

@WebServlet(name = "empread", urlPatterns = { "/empread.do" })
public class EmpReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		System.out.println("read¼­ºí¸´"+id);
		MemberDTO dto = null;
		empService service = new empServiceImpl();
		dto = service.read(id);
		
		request.setAttribute("dto", dto);
		request.setAttribute("menupath", "/menu/insa_menu.jsp");
		request.setAttribute("viewpath", "/emp/emp_read.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}

}
