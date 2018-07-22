package erp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import erp.dto.DeptDTO;
import erp.service.DeptService;
import erp.service.DeptServiceImpl;


@WebServlet("/dept/getname.do")
public class GetDeptNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		DeptService service = new DeptServiceImpl();
		ArrayList<DeptDTO> deptList = service.getDeptName();
		
		String menupath="";
		String viewpath="";
		menupath = "/menu/insa_menu.jsp";
		viewpath = "/emp/register.jsp";
		
		request.setAttribute("deptList", deptList);
		request.setAttribute("menupath", menupath);
		request.setAttribute("viewpath", viewpath);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);

	}

}
