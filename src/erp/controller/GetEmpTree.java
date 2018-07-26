package erp.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import erp.dto.DeptDTO;
import erp.dto.MemberDTO;
import erp.service.DeptService;
import erp.service.DeptServiceImpl;
import erp.service.empService;
import erp.service.empServiceImpl;

@WebServlet(name = "emptree", urlPatterns = { "/emptree.do" })
public class GetEmpTree extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDTO> dtolist = null;
		MemberDTO emp = null;
		response.setContentType("application/json; charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		String deptno=request.getParameter("deptno");
		System.out.println("getemptree"+deptno);
		PrintWriter pw = response.getWriter();
		empService service = new empServiceImpl();
		dtolist = service.emptree(deptno);
		System.out.println("arraylist ªÁ¿Ã¡Ó"+dtolist.size());
		JSONObject myjson = new JSONObject();
		JSONArray emplist = new JSONArray();
		JSONObject empjson = new JSONObject();
		for (int i = 0; i < dtolist.size(); i++) {
			emp = dtolist.get(i);

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
		   emplist.add(empjson);
		}
		myjson.put("emplist", emplist);
		
		pw.println(myjson.toJSONString());
		
		
		
		
		
		
		
		
	}

}
