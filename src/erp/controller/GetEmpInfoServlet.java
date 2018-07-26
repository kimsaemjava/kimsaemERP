package erp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import erp.dto.MemberDTO;
import erp.service.empService;
import erp.service.empServiceImpl;
@WebServlet(name = "getEmpInfo", urlPatterns = { "/getEmpInfo.do" })
public class GetEmpInfoServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("선택한사원id"+id);
		empService service = new empServiceImpl();
		MemberDTO emp = service.read(id);
		JSONObject rootjson = new JSONObject();
		JSONObject empjson = new JSONObject();
		empjson.put("id", emp.getId());
		empjson.put("pass", emp.getPass());
		empjson.put("name", emp.getName());
		empjson.put("ssn", emp.getSsn());
		empjson.put("birthday", emp.getBirthday().toString());
		empjson.put("position", emp.getPosition());
		empjson.put("duty", emp.getDuty());
		empjson.put("classes", emp.getClasses());
		empjson.put("startday", emp.getStartday().toString());
		empjson.put("endday", null);
		empjson.put("deptno", emp.getDeptno());
		empjson.put("curstate", emp.getCurstate());
		empjson.put("zipcode", emp.getZipcode());
		empjson.put("addr", emp.getAddr());
		empjson.put("detailaddr", emp.getDetailaddr());
		empjson.put("phonehome", emp.getPhonehome());
		empjson.put("phoneco", emp.getPhoneco());
		empjson.put("phonecell", emp.getPhonecell());
		empjson.put("email", emp.getEmail());
		empjson.put("profile_photo", emp.getProfile_photo());
		
		rootjson.put("empjson", empjson);
		
		response.setContentType("application/json; charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		PrintWriter pw = response.getWriter();
		pw.println(rootjson.toJSONString());
		

		
	
	}


}
