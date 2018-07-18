package basic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.empDTO;
import emp.service.empService;
import emp.service.empServiceImpl;
@WebServlet(name = "read", urlPatterns = { "/read.do" })
public class deptlistServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		empService service = new empServiceImpl();
		
		System.out.println("read»Æ¿Œ");
		String id = req.getParameter("id");
		String action=req.getParameter("action");
		System.out.println("action:"+action);
		empDTO user=service.read(id);
		req.setAttribute("mydata", user);
		
		String view="";
		
		if(action.equals("update")){
			view="/jspbasic/emp_update.jsp";
		}else{
			view="/jspbasic/emp_read.jsp";
		}
		RequestDispatcher rd= req.getRequestDispatcher(view);
		rd.forward(req,res);
		
		
	}
}

