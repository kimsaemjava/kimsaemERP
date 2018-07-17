package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static void main(String[] args){
		System.out.println(getConnect());
	}
	//1. 드라이버로딩
	//==> 메소드마다 드라이버를 로딩하는 작업을 구현하지 않고 클래스로더가 작업클래스를 로딩할때
	//    한 번만 실행되도록 작업하기 위해서 static블럭을 선언하고 코드를 작성
	static{
		try {
			//1. JDBC드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2. DB서버 연결 - 커넥션설정
	public static Connection getConnect(){
		Connection con = null;
		String url = "jdbc:oracle:thin:@211.42.204.107:1521:xe";
		String user = "scott";
		String password = "tiger";
		try{
			con =DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//3. 자원반납 - 각각의 메소드로 구현 or 한꺼번에 반납하는 메소드를 구현
	public static void close(ResultSet rs, Statement stmt, 
			Connection con){
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//커넥션을 반납하는 메소드
	public static void close(Connection con){
		try{
			if(con!=null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//Statement반납
	public static void close(Statement stmt){
		try{
			if(stmt!=null) stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//ResultSet반납
	public static void close(ResultSet rs){
		try{
			if(rs!=null) rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}











