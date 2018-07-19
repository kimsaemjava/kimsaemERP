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
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@211.42.204.20:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void close(ResultSet rs, Statement stmt, Connection con) {
		if (rs != null)
			try {
				rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	// Close ¹Ý³³
	public static void close(Connection con) {
		try {
			if(con !=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	// Statement¹Ý³³
	public static void close(Statement stmt) {
		try {
			if(stmt !=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	// ResultSet¹Ý³³
	public static void close(ResultSet rs) {
			try {
				if(rs !=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
}
