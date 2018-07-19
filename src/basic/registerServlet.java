package basic;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.empDAOImpl;
import emp.service.empService;
import emp.service.empServiceImpl;

public class registerServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
			
		String deptno=req.getParameter("deptno");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String addr=req.getParameter("addr");
		String po =req.getParameter("point");
		String grade=req.getParameter("grade");
		int point =Integer.parseInt(po);
		empService service = new empServiceImpl();
		String msg="";
		int result=service.insert(deptno, name, id, pass, addr, point, grade);
		if(result<=0){
			msg="»ðÀÔ½ÇÆÐ";
		}else{
			msg="»ðÀÔ¼º°ø";
		}
		req.setAttribute("mydata", msg);
		RequestDispatcher rd= req.getRequestDispatcher("/servlettest/result.jsp");
		rd.forward(req,res);
	}
}
