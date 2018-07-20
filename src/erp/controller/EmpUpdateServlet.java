package erp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.EmpDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;

@WebServlet(name = "emp/update", urlPatterns={"/emp/update.do"})
public class EmpUpdateServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		String grade = request.getParameter("grade");
		int point = Integer.parseInt(request.getParameter("point"));
		
		EmpDTO user = new EmpDTO(id, addr, grade, point);
		
		EmpService service = new EmpServiceImpl();
		int result = service.update(user);
		
		String view = "";
		if(result>=1){
			view="/serverweb/emp/list.do";
		}else{
			view="/serverweb/emp/read.do?id="+id+"&action=UPDATE";
		}
		
		response.sendRedirect(view);
	
	}
}
