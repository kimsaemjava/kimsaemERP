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
	static {	//µå¶óÀÌ¹ö·Îµù
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnect(){ //DB¼­¹ö ¿¬°á
		Connection con = null;
		String url = "jdbc:oracle:thin:@211.42.204.125:1521:xe";
		String user = "erp";
		String password = "erp";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//ÀÚ¿ø¹Ý³³
	public static void close(ResultSet rs, Statement stmt, Connection con){
		try{
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();		
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	//Connection¹Ý³³
	public static void close(Connection con){
		try{
			if (con != null) con.close();		
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	//Statement¹Ý³³
	public static void close(Statement stmt){
		try{
			if (stmt != null) stmt.close();	
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	//ResultSet¹Ý³³
	public static void close(ResultSet rs){
		try{
			if (rs != null) rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
}
