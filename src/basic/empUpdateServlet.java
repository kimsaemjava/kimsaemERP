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
@WebServlet(name = "update", urlPatterns = { "/update.do" })
public class empUpdateServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		empService service = new empServiceImpl();
		
		String addr = req.getParameter("addr");
		String grade = req.getParameter("grade");
		String value = req.getParameter("point");
		String id = req.getParameter("id");
		int point = Integer.parseInt(value);
		
		empDTO user= new empDTO(id,addr,grade,point);
		int result=service.update(user);
		String view="";
		System.out.println("»ğÀÔ°á°ú"+ result);
		if(result>=1){
			view="/serverweb/list.do";
		}else{
			System.out.println("»ğÀÔ½ÇÆĞ");
			view="/serverweb/read.do?id="+id+"&action=update";
		}
		res.sendRedirect(view);
	}
}

