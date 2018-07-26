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
// ajax 요청될떄 전달되는 부서번호를 받아서 해당부서에 근무하는 직원정보를 조회한다.
// 조회된 정보를 jsp 로 response 할때 비동기로 처리된 요청이므로 forward를 할수  없고
// 조회된 정보를 json으로 변환해서 response 해야한다.
@WebServlet(name = "emptree", urlPatterns = { "/emptree.do" })
public class GetEmpTree extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDTO> dtolist = null;
		String deptno=request.getParameter("deptno");
		System.out.println("getemptree"+deptno);
		empService service = new empServiceImpl();
		dtolist = service.emptree(deptno);
		System.out.println("arraylist 사이즈"+dtolist.size());
		
		//db로 조회한 데이터를 json으로 변환하는 작업
		JSONObject myjson = new JSONObject();
		JSONArray emplist = new JSONArray();
		for (int i = 0; i < dtolist.size(); i++) {
			// arraylist 에서 하나꺼낸 memberDTO를 json object로 변환
			MemberDTO emp = dtolist.get(i);// db에서 꺼낸거
			JSONObject empjson = new JSONObject(); // 새로만들어질객체
			// emp json에 db에서 꺼낸 emp의 정보들을 put 시켜야한다.
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
			//db레코드 -> dto -> JSONObject
			emplist.add(empjson);
		}
		// 변환된 JSONArray를 마지막으로 root인 JSONObject에 추가한다.
		myjson.put("emplist", emplist);
		System.out.println(myjson.toJSONString());
		
		response.setContentType("application/json; charset=euc-kr");
		response.setHeader("cache-control", "no-cache, no-store");
		PrintWriter pw = response.getWriter();
		pw.println(myjson.toJSONString());
		
		
		
	}

}
