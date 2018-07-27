package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/*String data = request.getParameter("data");
		System.out.println("추출한 파라미터=>"+data);*/
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/");
		FileWriter fw = new FileWriter(path+"/board/test.txt");
		fw.write("aaaatest");
		fw.flush();
		fw.close();
		
		FileReader fr = new FileReader(path+"/board/test.txt");
		System.out.println((char)fr.read());
	
	}

}









