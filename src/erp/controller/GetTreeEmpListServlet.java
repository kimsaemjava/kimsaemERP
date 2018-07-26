package erp.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
/*
 * ajax요청될 때 전달되는 부서번호를 받아서 해당 부서에 근무하는 직원정보를 조회한다.
 * 조회된 정보를 jsp로 response할 때 비동기로 처리된 요청이므로 forward를 할 수 없고 
 * 조회된 정보를 json으로 변환해서 response해야 한다.
*/
@WebServlet(name = "treedata", urlPatterns = { "/ajaxtreedata" })
public class GetTreeEmpListServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿요청성공");
		
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		
		String deptno = request.getParameter("deptno");
		System.out.println("부서번호 : "+deptno);
		EmpService service = new EmpServiceImpl();
		ArrayList<MemberDTO> emplist = service.getTreeEmpList(deptno);
		
		// DB로 조회한 데이터를 json으로 변환하는 작업
		JSONObject emproot = new JSONObject();
		JSONArray empjsonlist = new JSONArray();
		int size = emplist.size();
		
		// DB에서 조회한 레코드의 갯수만큼 for문을 돌리면서 작업
		for(int i=0;i<size;i++){

			// ArrayList에서 하나 꺼낸 MemberDTO를  SONObject로 변환
			MemberDTO emp = emplist.get(i);		// DB에서 꺼낸 것
			JSONObject empjson  =new JSONObject();	// 새로 만들어질 객체
			
			// empjson에 db에서 꺼낸 emp의 정보들을 put시켜야 한다.
			empjson.put("id", emp.getId());
			empjson.put("pass", emp.getPass());
			empjson.put("name", emp.getName());
			empjson.put("ssn", emp.getSsn());
			empjson.put("birthday", emp.getBirthday().toString());	// date는 toString을 사용해줘야지 json형식으로 만들어짐
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
			empjson.put("deptname", emp.getDeptname());
			
			// DB 레코드 -> DTO로 변환 -> JSONObject로 변환
			empjsonlist.add(empjson);
		}
		
		// 변환된 JSONArray를 마지막으로 root인 JSONObject에 추가한다.
		emproot.put("emplist", empjsonlist);
		System.out.println(emproot.toJSONString());
		
		// Ajax로 요청될 때 처리해야 하는 작업
		response.setContentType("application/json;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		
		PrintWriter pw = response.getWriter();
		pw.println(emproot.toJSONString());
	}
	
	// Servlet만 Test
/*	public static void main(String[] args){
		EmpService service = new EmpServiceImpl();
		ArrayList<MemberDTO> emplist = service.getTreeEmpList("d001");
		
		// DB로 조회한 데이터를 json으로 변환하는 작업
		JSONObject emproot = new JSONObject();
		JSONArray empjsonlist = new JSONArray();
		int size = emplist.size();
		
		// DB에서 조회한 레코드의 갯수만큼 for문을 돌리면서 작업
		for(int i=0;i<size;i++){

			// ArrayList에서 하나 꺼낸 MemberDTO를  SONObject로 변환
			MemberDTO emp = emplist.get(i);		// DB에서 꺼낸 것
			JSONObject empjson  =new JSONObject();	// 새로 만들어질 객체
			
			// empjson에 db에서 꺼낸 emp의 정보들을 put시켜야 한다.
			empjson.put("id", emp.getId());
			empjson.put("pass", emp.getPass());
			empjson.put("name", emp.getName());
			empjson.put("ssn", emp.getSsn());
			empjson.put("birthday", emp.getBirthday().toString());	// date는 toString을 사용해줘야지 json형식으로 만들어짐
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
			empjson.put("deptname", emp.getDeptname());
			
			// DB 레코드 -> DTO로 변환 -> JSONObject로 변환
			empjsonlist.add(empjson);
		}
		
		// 변환된 JSONArray를 마지막으로 root인 JSONObject에 추가한다.
		emproot.put("emplist", empjsonlist);
		System.out.println(emproot.toJSONString());
	}*/
}
		