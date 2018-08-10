package erp.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "emp/insert", urlPatterns = { "/emp/insert.do" })
public class EmpInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("���� ��û ����");

		//req.setCharacterEncoding("euc-kr");
		//fileuploadó��
		String saveFolder = "/upload";
		String encType = "euc-kr";
		int size = 5*1024*1024; 
		String realpath = "";
		
		ServletContext context = getServletContext();
		realpath = context.getRealPath(saveFolder);
		MultipartRequest multipart = new MultipartRequest(req, realpath, size, encType, new DefaultFileRenamePolicy());
		
		// 1. Ŭ���̾�Ʈ�� ��û���� ����
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
		String profile_photo = "";
		
		//marry�� ���� ó��
		if(marry==null){ //üũ�ڽ��� �������� ���� ��ȥ�̶�� �ǹ�
			marry = "0";
		}
		//��¥ �����͸� Date�� ó���ϴ� ��� - �Է������� ��¥ �����Ϳ� �°� �Է¹��� �� �ֵ��� view���� ����
		//String ��¥�� java.sql.DateŸ������ ��ȯ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		long mydate=0;
		try {
			mydate = sdf.parse(birthday).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//���Ͼ��ε�ó��
		Enumeration<String> files = multipart.getFileNames();
		while(files.hasMoreElements()){
			String file = files.nextElement();
			profile_photo = multipart.getFilesystemName(file);
		}
		
		// 2. �����Ͻ� �޼ҵ� ȣ��
		EmpService service = new EmpServiceImpl();
		MemberDTO user = new MemberDTO(id, pass, name, ssn, new Date(mydate), marry, deptno, zipcode, addr, detailaddr,
				phonehome, phoneco, phonecell, email, profile_photo);
		int result = service.insert(user);

		// 3. ��û������
		res.sendRedirect("/kimsaemERP/emp/list.do");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
