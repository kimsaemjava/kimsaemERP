package emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

@WebServlet(name = "emp/read", urlPatterns={"/emp/read.do"})
public class EmpReadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("������ ��û ����");
		request.setCharacterEncoding("euc-kr");
		
		//1. ��û���� ����
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String view = "";
		if(action.equals("UPDATE")){
			view = "/emp/emp_update.jsp";
		}else if(action.equals("READ")){
			view = "/emp/emp_read.jsp";
		}
		
		//2. �����Ͻ��޼ҵ� ȣ��
		EmpService service = new EmpServiceImpl();
		EmpDTO user = service.read(id);

		//3. ������ ����
		request.setAttribute("user", user);
		
		//4. ��û������
		RequestDispatcher rd = request.getRequestDispatcher(view); 
		rd.forward(request, response);
		
		
	}
}