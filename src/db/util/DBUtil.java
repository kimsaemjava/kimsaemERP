package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	public static void main(String[] args){
		System.out.println(getConnect());
	}
	
	static {
		try {//1. JDBC드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 에러의 근원지를 찾아 단계별 에러를 출력
		}
	}
	//2. DB연결
	//
	public static Connection getConnect(){
		Connection con = null;	//초기화
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		try{	//드라이브 로딩
			con = DriverManager.getConnection(url, user, password);
			//url로 user와 password 입력하면 연결
		}catch(SQLException e){ //SQL Server에서 경고 또는 오류 반환할때 throw되는 예외
			e.printStackTrace();
		}
		return con;
	}
	//자원 반납
	public static void close(Connection con){
		try{
			if(con != null)	//연결이 null이 아니면
				con.close();//끊어라.
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ptmt){
		try{
			if(ptmt != null)
				ptmt.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
