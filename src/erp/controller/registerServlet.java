package erp.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp.dto.MemberDTO;
import erp.service.empService;
import erp.service.empServiceImpl;
@WebServlet(name = "insert", urlPatterns = { "/insert.do" })
public class registerServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,java.io.IOException{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
			
		String deptno=req.getParameter("deptno");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String ssn=req.getParameter("ssn");
		String birthday =req.getParameter("birthday");
		String marry = req.getParameter("marry");
		String zipcode = req.getParameter("zipcode");
		String addr =req.getParameter("addr");
		String phonehome = req.getParameter("phonehome");
		String phoneco = req.getParameter("phoneco");
		String phonecell = req.getParameter("phonecell");
		String email = req.getParameter("email");
//		String profile_photo = req.getParameter("userImage");
		String profile_photo = "myphoto.jpg";
		
		MemberDTO dto = new MemberDTO(id, pass, name, ssn,  birthday,
					marry, deptno, zipcode, addr, phonehome, phoneco, phonecell,
					email, profile_photo);
		System.out.println(dto);
		empService service = new empServiceImpl();
		int result = service.insert(dto);

		String msg="";
		if(result<=0){
			msg="»ðÀÔ½ÇÆÐ";
		}else{
			msg="»ðÀÔ¼º°ø";
		}
		System.out.println(msg);
		req.setAttribute("mydata", msg);
		req.setAttribute("menupath", "/menu/insa_menu.jsp");
		req.setAttribute("viewpath", "/emp/emp_list.jsp");
		RequestDispatcher rd= req.getRequestDispatcher("/template/mainLayout.jsp");
		rd.forward(req,res);
	}
}
