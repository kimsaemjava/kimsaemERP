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

@WebServlet(name = "getname", urlPatterns = { "/getname.do" })
public class GetDeptNameServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		System.out.println("서블릿요청성공");
		String action = request.getParameter("action");
		String viewpath = "";
		if(action.equals("register")){
			viewpath="/emp/register.jsp";
		}else if(action.equals("tree")){
			viewpath="/dept/tree.jsp";
		}else if(action.equals("org")){
			viewpath="/dept/realtree.jsp";
		}
		//비지니스 메소드 호출
		DeptService service = new DeptServiceImpl();
		ArrayList<DeptDTO> deptnamelist = service.getDeptName();
		
		System.out.println("서블릿"+deptnamelist);
		//데이터공유
		request.setAttribute("deptnamelist", deptnamelist);
		request.setAttribute("menupath", "/menu/insa_menu.jsp");
		request.setAttribute("viewpath", viewpath);
		//요청재지정
		RequestDispatcher rd = 
			request.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(request, response);
	}
}
