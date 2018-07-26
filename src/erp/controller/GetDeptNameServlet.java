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

@WebServlet(name = "getname", urlPatterns = { "/dept/getname.do" })
public class GetDeptNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		ArrayList<DeptDTO> list = null;
		DeptService service = new DeptServiceImpl();
		list = service.getDeptName();
		String action = request.getParameter("action");
		
		
		if(action.equals("register")){
			request.setAttribute("viewpath", "/emp/register.jsp");
		}else{
			request.setAttribute("viewpath", "/dept/tree.jsp");
		}
		request.setAttribute("list", list);
		request.setAttribute("menupath", "/menu/insa_menu.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}

}
