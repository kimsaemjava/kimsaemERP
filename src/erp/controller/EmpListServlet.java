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
import erp.service.DeptService;
import erp.service.DeptServiceImpl;
import erp.service.empService;
import erp.service.empServiceImpl;

@WebServlet(name = "emplist", urlPatterns = { "/emplist.do" })
public class EmpListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<DeptDTO> list = null;
		empService service = new empServiceImpl();
		list = service.emplist();
		System.out.println("리턴사이즈"+list.size());
		request.setAttribute("list", list);
		request.setAttribute("menupath", "/menu/insa_menu.jsp");
		request.setAttribute("viewpath", "/emp/emp_list.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}

}
