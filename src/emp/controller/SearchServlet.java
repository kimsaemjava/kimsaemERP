package emp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

@WebServlet(name = "emp/search", urlPatterns = { "/emp/search.do" })
public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		// 1. 클라이언트의 요청정보 추출
		String column = request.getParameter("column");
		String search = request.getParameter("search");
		System.out.println("검색어: "+search);

		// 2. 비즈니스 메소드 호출
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> empList= service.search(column, search);

		// 3. 데이터 공유
		request.setAttribute("empList", empList);
		
		// 4. 요청재지정 - forward
		RequestDispatcher rd = request.getRequestDispatcher("/emp/list.jsp");
		rd.forward(request, response);
	
	}


}
