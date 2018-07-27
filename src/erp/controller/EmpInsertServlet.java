package erp.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import erp.dto.MemberDTO;
import erp.service.EmpService;
import erp.service.EmpServiceImpl;
@WebServlet(name="emp/insert" , urlPatterns={"/emp/insert.do"})
public class EmpInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("서블릿 요청 성공^^");
		
		String saveFolder="/upload";
		String encType = "euc-kr";
		int size  = 5*1024*1024;
		String realpath = "";
		ServletContext context = getServletContext();
		realpath = context.getRealPath(saveFolder);
		
		MultipartRequest multipart = 
				new MultipartRequest(req, realpath,
						size, encType,
						    new DefaultFileRenamePolicy());
		
		// 1. 클라이언트의 요청정보 추출
		String id = multipart.getParameter("id");
		String pass = multipart.getParameter("pass");
		String name = multipart.getParameter("name");
		String birthday = multipart.getParameter("birthday");
		String ssn = multipart.getParameter("ssn");
		String marry = multipart.getParameter("marry");
		String gender = multipart.getParameter("gender");
		String deptno = multipart.getParameter("deptno");
		String zipcode = multipart.getParameter("zipcode");
		String addr = multipart.getParameter("addr");
		String detailaddr = multipart.getParameter("detailaddr");
		String phonehome = multipart.getParameter("phonehome");
		String phoneco = multipart.getParameter("phoneco");
		String phonecell = multipart.getParameter("phonecell");
		String email = multipart.getParameter("email");
		
		String fileName = "";
		Enumeration<String> files =  multipart.getFileNames();
		while(files.hasMoreElements()){//파일이 존재하면
			String file = files.nextElement();//파일명을 꺼내라
			fileName =	multipart.getFilesystemName(file);
		}
		
		//marry에 대한 처리
		if(marry==null){//체크박스를 선택하지 않은 미혼이라는 의미
			marry = "0";
		}
		
		//날짜 데이터를 Date로 처리하는 경우 -
		//입력형식은 날짜 데이터에 맞게 입력받을 수 있도록 view에서 정의		
		//String날짜를 java.sql.Date타입으로 변환
		SimpleDateFormat sdf= 
				new SimpleDateFormat("yyyy/MM/dd");
		long mydate=0;
		try {
			mydate = sdf.parse(birthday).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 2. 비지니스 메소드 호출
		MemberDTO user = new MemberDTO(id, pass, name, ssn, 
				new Date(mydate), marry, deptno, zipcode, addr, 
				detailaddr,phonehome, phoneco, phonecell, email,
				fileName);
		
		System.out.println("서블릿=>"+user);
		EmpService service = new EmpServiceImpl();
		int result = service.insert(user);

		res.sendRedirect("/kimsaemERP/emp/list.do");
	}
}
